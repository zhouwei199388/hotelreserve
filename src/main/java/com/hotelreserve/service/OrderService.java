package com.hotelreserve.service;

import com.google.gson.Gson;
import com.hotelreserve.http.ConnectionMessage;
import com.hotelreserve.http.WXmessage;
import com.hotelreserve.http.model.OrderModel;
import com.hotelreserve.http.request.OrderRequest;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.response.OrderResponse;
import com.hotelreserve.http.response.PrePayResponse;
import com.hotelreserve.mapper.*;
import com.hotelreserve.model.*;
import com.hotelreserve.utils.ClientCustomSSL;
import com.hotelreserve.utils.LogUtils;
import com.hotelreserve.utils.RequestHandler;
import com.hotelreserve.wxpay.PayUtils;
import com.hotelreserve.wxpay.WxPayConfig;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by 15090 on 2018/12/29.
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper mOrderMapper;
    @Autowired
    private HotelInfoMapper mHotelInfoMapper;
    @Autowired
    private HotelRoomMapper mHotelRoomMapper;
    @Autowired
    private UserMapper mUserMapper;
    @Autowired
    private PreOrderResponseMapper mPreOrderMapper;

    public PrePayResponse addOrder(Order order) {
        PrePayResponse response = new PrePayResponse();
        ResponseHeader header = new ResponseHeader();
        int type = mOrderMapper.insert(order);
        if (type != 0) {
            header.setSuccess();
        }
        response.header = header;
        return response;
    }

    public PrePayResponse wxPrePay(OrderRequest orderModel) {
        LogUtils.info(new Gson().toJson(orderModel));
        PrePayResponse response = new PrePayResponse();
        ResponseHeader header = new ResponseHeader();
        User user = mUserMapper.selectByPrimaryKey(orderModel.userid);
        if (user == null) {
            header.msg = ConnectionMessage.USER_NOT_EXISTS;
            response.header = header;
            return response;
        }
        response = wxPrePay(user.getOpenid(), orderModel);
        return response;
    }

    /**
     * @param model
     * @Description: 同一订单支付
     */
    @Transactional
    public PrePayResponse wxPrePay(String openid, OrderRequest model) {
        try {
            //生成的随机字符串
            String nonce_str = PayUtils.getRandomStringByLength(32);
            //商品名称
            String body = "客房预订";
//            //获取客户端的ip地址
//            String spbill_create_ip = IpUtil.getIpAddr(request);

            //组装参数，用户生成统一下单接口的签名
            Map<String, String> packageParams = new HashMap<String, String>();
            packageParams.put("appid", WxPayConfig.appid);
            packageParams.put("mch_id", WxPayConfig.mch_id);
            packageParams.put("nonce_str", nonce_str);
            packageParams.put("out_trade_no", model.ordernumber);//商户订单号
            packageParams.put("body", body);

            packageParams.put("total_fee", model.getPrice());//支付金额，这边需要转成字符串类型，否则后面的签名会失败
//            packageParams.put("spbill_create_ip", spbill_create_ip);
            packageParams.put("notify_url", WxPayConfig.notify_url);//支付成功后的回调地址
            packageParams.put("trade_type", WxPayConfig.TRADETYPE);//支付方式
            packageParams.put("openid", openid);

            String prestr = PayUtils.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
            LogUtils.info("prestr = " + prestr);
            //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
            String mysign = PayUtils.sign(prestr, WxPayConfig.key, "utf-8").toUpperCase();
            LogUtils.info("MD5生成签名" + mysign);
            //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
            String xml = "<xml>" + "<appid>" + WxPayConfig.appid + "</appid>"
                    + "<body>" + body + "</body>"
                    + "<mch_id>" + WxPayConfig.mch_id + "</mch_id>"
                    + "<nonce_str>" + nonce_str + "</nonce_str>"
                    + "<notify_url>" + WxPayConfig.notify_url + "</notify_url>"
                    + "<openid>" + openid + "</openid>"
                    + "<out_trade_no>" + model.ordernumber + "</out_trade_no>"
                    + "<total_fee>" + model.getPrice() + "</total_fee>"
                    + "<trade_type>" + WxPayConfig.TRADETYPE + "</trade_type>"
                    + "<sign>" + mysign + "</sign>"
                    + "</xml>";

            LogUtils.info("调试模式_统一下单接口 请求XML数据：" + xml);
            //调用统一下单接口，并接受返回的结果
            String result = PayUtils.httpRequest(WxPayConfig.pay_url, "POST", xml);
            LogUtils.info("调试模式_统一下单接口 请求XML数据：" + result);

            // 将解析结果存储在HashMap中
            Map map = PayUtils.doXMLParse(result);

            String return_code = (String) map.get("return_code");//返回状态码

            PrePayResponse response = new PrePayResponse();//返回给小程序端需要的参数
            PreOrderResponse preOrderResponse = new PreOrderResponse();
            ResponseHeader header = new ResponseHeader();
            if (return_code.equals("SUCCESS")) {
                response = new PrePayResponse();
                Order order = model.copyToHotel();
                order.setStatus(0);
                int resultCode = mOrderMapper.insert(order);
                if (resultCode != 1) {
                    response.header = header;
                    return response;
                }
                preOrderResponse.setNoncestr(nonce_str);
                String prepay_id = (String) map.get("prepay_id");//返回的预付单信息
                preOrderResponse.setPackagestr("prepay_id=" + prepay_id);
                Long timeStamp = System.currentTimeMillis() / 1000;
                preOrderResponse.setTimestamap(timeStamp + "");//这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
                //拼接签名需要的参数
                String stringSignTemp = "appId=" + WxPayConfig.appid + "&nonceStr=" + nonce_str + "&package=prepay_id=" + prepay_id + "&signType=MD5&timeStamp=" + timeStamp;
                //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
                String paySign = PayUtils.sign(stringSignTemp, WxPayConfig.key, "utf-8").toUpperCase();
                preOrderResponse.setPaysign(paySign);
                preOrderResponse.setAppid(WxPayConfig.appid);
                preOrderResponse.setOrderid(order.getId());
                int preResult = mPreOrderMapper.insert(preOrderResponse);
                if (preResult != 0) {
                    response.preOrder = preOrderResponse;
                    header.setSuccess();
                }
                response.header = header;
            }
            response.header = header;
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 支付成功回调
     *
     * @param status
     * @param orderNumber
     * @return
     */
    public boolean updateOrderStatus(int status, String orderNumber, String price,String transactionId) {

        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrdernumberEqualTo(orderNumber);
        List<Order> orders = mOrderMapper.selectByExample(example);
        if (orders.size() == 0) {
            LogUtils.info("订单不存在");
            return false;
        }
        Order order = orders.get(0);
        order.setStatus(status);
        order.setTransactionid(transactionId);
        int result = mOrderMapper.updateByPrimaryKey(order);
        if (result == 0) {
            LogUtils.info(new Gson().toJson(order));
            LogUtils.info("状态修改失败");
            return false;
        }
        PreOrderResponseExample example1 = new PreOrderResponseExample();
        PreOrderResponseExample.Criteria preCriteria = example1.createCriteria();
        preCriteria.andOrderidEqualTo(order.getId());
        int preResult = mPreOrderMapper.deleteByExample(example1);
        if (preResult == 0) {
            LogUtils.info("订单支付参数删除失败");
            return false;
        }
        return true;
    }

    /**
     * 修改订单状态
     *
     * @param id
     * @param status
     * @return
     */
    public ResponseHeader updateOrderStatus(int id, int status) {
        ResponseHeader header = new ResponseHeader();
        Order order = new Order();
        order.setId(id);
        order.setStatus(status);
        int result = mOrderMapper.updateByPrimaryKeySelective(order);
        if (result != 0) {
            header.setSuccess();
        }
        return header;
    }

    /**
     * 获取所有订单
     *
     * @return
     */
    public OrderResponse getAllOrder() {
        OrderResponse response = new OrderResponse();
        ResponseHeader header = new ResponseHeader();
        OrderExample orderExample = new OrderExample();
        orderExample.setOrderByClause("'creteTime' ASC");
        List<Order> orders = mOrderMapper.selectByExample(orderExample);
        LogUtils.info(new Gson().toJson(orders));
        List<OrderModel> orderModels = new ArrayList<>();
        for (Order order : orders) {
            OrderModel model = new OrderModel();
            HotelInfo hotelInfo = mHotelInfoMapper.selectByPrimaryKey(order.getHotelid());
            HotelRoom hotelRoom = mHotelRoomMapper.selectByPrimaryKey(order.getRoomid());
            User user = mUserMapper.selectByPrimaryKey(order.getUserid());
            PreOrderResponseExample example = new PreOrderResponseExample();
            PreOrderResponseExample.Criteria criteria = example.createCriteria();
            criteria.andOrderidEqualTo(order.getId());
            List<PreOrderResponse> preOrder = mPreOrderMapper.selectByExample(example);
            user.setOpenid(null);
            user.setSessionkey(null);
            model.hotelInfo = hotelInfo;
            model.hotelRoom = hotelRoom;
            if (preOrder.size() != 0) {
                model.preOrder = preOrder.get(0);
            }
            model.setOrder(order);
            model.user = user;
            orderModels.add(model);
        }
        header.setSuccess();
        response.header = header;
        response.orders = orderModels;
        return response;
    }

    /**
     * @param userId
     * @return
     */
    public OrderResponse getMyOrder(int userId, int status) {
        OrderResponse response = new OrderResponse();
        ResponseHeader header = new ResponseHeader();
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria orderCriteria = orderExample.createCriteria();
        orderCriteria.andUseridEqualTo(userId);
        if (status != -1) {
            orderCriteria.andStatusEqualTo(status);
        }
        orderExample.setOrderByClause("'creteTime' ASC");
        List<Order> orders = mOrderMapper.selectByExample(orderExample);
        LogUtils.info(new Gson().toJson(orders));
        List<OrderModel> orderModels = new ArrayList<>();
        for(Order order:orders){
            OrderModel model = new OrderModel();
            HotelInfo hotelInfo = mHotelInfoMapper.selectByPrimaryKey(order.getHotelid());
            HotelRoom hotelRoom = mHotelRoomMapper.selectByPrimaryKey(order.getRoomid());
            User user = mUserMapper.selectByPrimaryKey(order.getUserid());
            PreOrderResponseExample example = new PreOrderResponseExample();
            PreOrderResponseExample.Criteria criteria = example.createCriteria();
            criteria.andOrderidEqualTo(order.getId());
            List<PreOrderResponse> preOrder = mPreOrderMapper.selectByExample(example);
            user.setOpenid(null);
            user.setSessionkey(null);
            model.hotelInfo = hotelInfo;
            model.hotelRoom = hotelRoom;
            if (preOrder.size() != 0) {
                model.preOrder = preOrder.get(0);
            }
            model.setOrder(order);
            model.user = user;
            orderModels.add(model);
        }
        header.setSuccess();
        response.header = header;
        response.orders = orderModels;
        return response;
    }


    /**
     * 退款
     *
     * @return
     */
    @Transactional
    public ResponseHeader wechatRefund(int orderId) {
        ResponseHeader header = new ResponseHeader();
        Order order = mOrderMapper.selectByPrimaryKey(orderId);
        LogUtils.info(new Gson().toJson(order));
        if (order == null) {
            return header;
        }
        String transaction_id = order.getTransactionid();
        String total_fee = String.valueOf((int)(order.getPrice()*100));
        String refund_fee = String.valueOf((int)(order.getPrice()*100));

        String nonce_str = PayUtils.getRandomStringByLength(32);// 随机字符串
        String out_refund_no = UUID.randomUUID().toString().substring(0, 32).replace("-", "");
        SortedMap<String, String> packageParams = new TreeMap<String, String>();
        packageParams.put("appid", WxPayConfig.appid);
        packageParams.put("mch_id", WxPayConfig.mch_id);
        packageParams.put("nonce_str", nonce_str);
        packageParams.put("transaction_id", transaction_id);
        packageParams.put("out_refund_no", out_refund_no);
        packageParams.put("total_fee", total_fee);
        packageParams.put("refund_fee", refund_fee);
        packageParams.put("op_user_id", WxPayConfig.mch_id);
        RequestHandler reqHandler = new RequestHandler(null, null);
        reqHandler.init(WxPayConfig.appid, WxPayConfig.appsecret, WxPayConfig.key);

        String sign = reqHandler.createSign(packageParams);
        String xml = "<xml>" +
                "<appid>" + WxPayConfig.appid + "</appid>" +
                "<mch_id>" + WxPayConfig.mch_id + "</mch_id>" +
                "<nonce_str>" + nonce_str + "</nonce_str>" +
                "<sign>" + sign + "</sign>" +
                "<transaction_id>" + transaction_id + "</transaction_id>" +
                "<out_refund_no>" + out_refund_no + "</out_refund_no>" +
                "<total_fee>" + total_fee + "</total_fee>" +
                "<refund_fee>" + refund_fee + "</refund_fee>" +
                "<op_user_id>" + WxPayConfig.mch_id + "</op_user_id>" +
                "</xml>";
        LogUtils.info(xml);
        String createOrderURL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
        try {
            ClientCustomSSL ccs = new ClientCustomSSL();
            Map<String, String> map = ccs.doRefund(createOrderURL, xml);
            String resultCode = map.get("return_code");
            if("SUCCESS".equals(resultCode)){
                if("SUCCESS".equals(map.get("result_code"))){
                    order.setStatus(3);
                    int returnCode = mOrderMapper.updateByPrimaryKey(order);
                    if(returnCode!=0){
                        header.code= ConnectionMessage.SUCCESS_CODE;
                        header.msg = "退款成功";
                    }else{
                        header.code= ConnectionMessage.SERVER_ERROR_CODE;
                        header.msg = ConnectionMessage.SERVER_ERROR_TEXT;
                    }
                }else{
                    header.code= ConnectionMessage.SERVER_ERROR_CODE;
                    header.msg = map.get("err_code_des");
                }
            }else{
                header.code= ConnectionMessage.SERVER_ERROR_CODE;
                header.msg = map.get("return_msg");
            }

            LogUtils.info(map.toString());
            return header;
            //改变支付数据库中的是否退款
            //新增退款数据库数据

        } catch (Exception e) {
            e.printStackTrace();
        }
        return header;
    }

}
