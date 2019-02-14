package com.hotelreserve.wxpay;

/**
 * Created by 15090 on 2019/1/2.
 */
public class WxPayConfig {


    public static final int PRE_PAY = 0;//下单预支付
    public static final int TO_SIGN_IN= 1;//已支付  待入住
    public static final int HAS_BEEN_IN= 2;// 已入住  消费完成


    public static final String FIELD_SIGN = "sign";
    public static final String FIELD_SIGN_TYPE = "sign_type";
    //小程序appid
    public static final String appid = "wxe7b86a74f9e96203";
    //小程序secret
    public static final String appsecret = "wxe7b86a74f9e96203";
    //微信支付的商户id
    public static final String mch_id = "1519070531";
    //微信支付的商户密钥
    public static final String key = "42098419930501635x42098419930501";
    //支付成功后的服务器回调url
    public static final String notify_url = "https://zwwjj1314.com/api/order/wxNotify";
    //签名方式，固定值
    public static final String SIGNTYPE = "MD5";
    //交易类型，小程序支付的固定值为JSAPI
    public static final String TRADETYPE = "JSAPI";
    //微信统一下单接口地址
    public static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
}
