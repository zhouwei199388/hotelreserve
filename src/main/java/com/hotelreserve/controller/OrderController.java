package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.http.model.OrderModel;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.response.OrderResponse;
import com.hotelreserve.model.Order;
import com.hotelreserve.service.OrderService;
import com.hotelreserve.utils.LogUtils;
import com.hotelreserve.utils.ResponseUtils;
import com.hotelreserve.wxpay.PayUtils;
import com.hotelreserve.wxpay.WxPayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addOrder(HttpServletResponse response, @RequestBody Order order){
        LogUtils.info(new Gson().toJson(order));
        OrderResponse orderResponse = mOrderService.addOrder(order);
        ResponseUtils.renderJson(response,new Gson().toJson(orderResponse));
    }

    @ResponseBody
    @RequestMapping(value = "/wxPrePay", method = RequestMethod.POST)
    public void wxPrePay(HttpServletResponse response,@RequestBody OrderModel order) {
        OrderResponse orderResponse = mOrderService.wxPrePay(order);
        ResponseUtils.renderJson(response,new Gson().toJson(orderResponse));
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
        System.out.println("接收到的报文：" + notityXml);

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


                /**此处添加自己的业务逻辑代码end**/
                //通知微信服务器已经支付成功
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            }
        } else {
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
        System.out.println(resXml);
        System.out.println("微信支付回调数据结束");


        BufferedOutputStream out = new BufferedOutputStream(
                response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
    }

}
