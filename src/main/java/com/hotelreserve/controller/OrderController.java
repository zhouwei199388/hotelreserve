package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.request.OrderRequest;
import com.hotelreserve.http.request.RoomNumberRequest;
import com.hotelreserve.http.response.OrderResponse;
import com.hotelreserve.http.response.PrePayResponse;
import com.hotelreserve.model.Order;
import com.hotelreserve.service.OrderService;
import com.hotelreserve.utils.LogUtils;
import com.hotelreserve.utils.ResponseUtils;
import com.hotelreserve.wxpay.PayUtils;
import com.hotelreserve.wxpay.WxPayConfig;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by 15090 on 2018/12/29.
 */
@Controller
@RequestMapping(value = "/api/order")
public class OrderController {

    @Autowired
    private OrderService mOrderService;

    @ResponseBody
    @RequestMapping(value = "/wxPrePay", method = RequestMethod.POST)
    public void wxPrePay(HttpServletResponse response, @RequestBody OrderRequest order) {
        PrePayResponse prePayResponse = mOrderService.wxPrePay(order);
        LogUtils.info(new Gson().toJson(prePayResponse));
        ResponseUtils.renderJson(response, new Gson().toJson(prePayResponse));
    }

    @ResponseBody
    @RequestMapping(value = "/wxRefund", method = RequestMethod.GET)
    public void wxRefund(HttpServletResponse response, int orderId) {
        ResponseHeader header = mOrderService.wechatRefund(orderId);
        LogUtils.info(new Gson().toJson(header));
        ResponseUtils.renderJson(response, new Gson().toJson(header));
    }

    @ResponseBody
    @RequestMapping(value = "/setRoomNum", method = RequestMethod.POST)
    public void setRoomNum(HttpServletResponse response, @RequestBody RoomNumberRequest request) {
        LogUtils.info(new Gson().toJson(request));
        ResponseHeader header = mOrderService.setRoomNum(request);
        LogUtils.info(new Gson().toJson(header));
        ResponseUtils.renderJson(response,new Gson().toJson(header));
    }

    /**
     * @return
     * @throws Exception
     * @Description:微信支付回调
     */
    @RequestMapping(value = "/wxNotify")
    @ResponseBody
    public void wxNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        //sb为微信返回的xml
        String notityXml = sb.toString();
        String resXml = "";
        LogUtils.info("接收到的报文：" + notityXml);

        Map map = PayUtils.doXMLParse(notityXml);

        String returnCode = (String) map.get("return_code");
        if ("SUCCESS".equals(returnCode)) {
            //验证签名是否正确
            Map<String, String> validParams = PayUtils.paraFilter(map);  //回调验签时需要去除sign和空值参数
            String validStr = PayUtils.createLinkString(validParams);//把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
            String sign = PayUtils.sign(validStr, WxPayConfig.key, "utf-8").toUpperCase();//拼装生成服务器端验证的签名

            //根据微信官网的介绍，此处不仅对回调的参数进行验签，还需要对返回的金额与系统订单的金额进行比对等
            if (sign.equals(map.get("sign"))) {
                /**此处添加自己的业务逻辑代码start**/
                String orderNumber = (String) map.get("out_trade_no");
                String price = (String) map.get("total_fee");
                String transactionId = (String) map.get("transaction_id");
                LogUtils.info(transactionId);
                LogUtils.info(map.toString());
                mOrderService.updateOrderStatus(WxPayConfig.TO_SIGN_IN, orderNumber, price, transactionId);

                /**此处添加自己的业务逻辑代码end**/
                //通知微信服务器已经支付成功
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            }
        } else {
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
        LogUtils.info(resXml);
        LogUtils.info("微信支付回调数据结束");


        BufferedOutputStream out = new BufferedOutputStream(
                response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
    }

    @ResponseBody
    @RequestMapping(value = "/getAllOrder", method = RequestMethod.GET)
    public void getAllOrder(HttpServletResponse response) {
        OrderResponse orderResponse = mOrderService.getAllOrder();
        ResponseUtils.renderJson(response, new Gson().toJson(orderResponse));
    }

    @ResponseBody
    @RequestMapping(value = "/getMyOrder", method = RequestMethod.GET)
    public void getMyOrder(HttpServletResponse response, int userId, int status) {
        LogUtils.info("userId:" + userId + "  status:" + status);
        OrderResponse orderResponse = mOrderService.getMyOrder(userId, status);
        ResponseUtils.renderJson(response, new Gson().toJson(orderResponse));
    }

}
