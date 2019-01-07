package com.hotelreserve.http.response;


import java.util.Map;

/**
 * Created by 15090 on 2018/12/29.
 */
public class OrderResponse extends BaseResponse{
    public String appId;
    public String timeStamap;
    public String nonceStr;
    public String packageStr;
    public String paySign;

    public void setData(Map<String,Object> map){

    }
}
