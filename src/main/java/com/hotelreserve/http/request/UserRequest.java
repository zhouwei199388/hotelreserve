package com.hotelreserve.http.request;

/**
 * Created by zouwei on 2018/12/4.
 */
public class UserRequest {
    public String code;
    public String encryptedData;
    public String iv;

    @Override
    public String toString() {
        return "UserRequest{" +
                "code='" + code + '\'' +
                ", encryptedData='" + encryptedData + '\'' +
                ", iv='" + iv + '\'' +
                '}';
    }
}
