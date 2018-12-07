package com.hotelreserve.http.request;

/**
 * Created by zouwei on 2018/12/7.
 */
public class BindPhoneRequest {
    public int id;
    public String phone;

    @Override
    public String toString() {
        return "BindPhoneRequest{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                '}';
    }
}
