package com.hotelreserve.wxpay;

/**
 * Created by 15090 on 2019/1/2.
 */
public class WxPayConfig {
    //小程序appid
    public static final String appid = "wxe7b86a74f9e96203";
    //微信支付的商户id
    public static final String mch_id = "1519070531";
    //微信支付的商户密钥
    public static final String key = "42098419930501635x42098419930501";
    //支付成功后的服务器回调url
    public static final String notify_url = "https://zwwjj1314.com/api/wxNotify";
    //签名方式，固定值
    public static final String SIGNTYPE = "MD5";
    //交易类型，小程序支付的固定值为JSAPI
    public static final String TRADETYPE = "JSAPI";
    //微信统一下单接口地址
    public static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
}
