package com.hotelreserve.http.model;

/**
 * Created by 15090 on 2018/12/6.
 */
public class WxUserInfo {

    public String openId;
    public String nickName;
    public String language;
    public int gender;
    public String province;
    public String city;
    public String avatarUrl;
    public WaterMark watermark;
    public static class WaterMark{
        public int timestamp;
        public String appid;
    }

    @Override
    public String toString() {
        return "WxUserInfo{" +
                "openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", language='" + language + '\'' +
                ", gender=" + gender +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", watermark=" + watermark +
                '}';
    }
}
