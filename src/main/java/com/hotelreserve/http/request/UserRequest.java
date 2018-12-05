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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }
}
