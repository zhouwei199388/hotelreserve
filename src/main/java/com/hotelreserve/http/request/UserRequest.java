package com.hotelreserve.http.request;

/**
 * Created by zouwei on 2018/12/4.
 */
public class UserRequest {
    public String code;
    public String key;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "code='" + code + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
