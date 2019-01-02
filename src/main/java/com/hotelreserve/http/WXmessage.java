package com.hotelreserve.http;

/**
 * Created by zouwei on 2019/1/2.
 */
public class WXmessage {

    //腾讯云短信appid
    public static final int APP_ID = 1400156282; // 1400开头
    // 短信应用SDK AppKey
    public static final String APP_KEY="7324d0e4d31f878428d407498a2f0bc8";
    // 短信模板ID，需要在短信应用中申请
    public static final int TEMPLATE_ID = 221620; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
    //templateId7839对应的内容是"您的验证码是: {1}"
     // 签名
    public static final  String SMS_SIGN = "四季星酒店"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使
}
