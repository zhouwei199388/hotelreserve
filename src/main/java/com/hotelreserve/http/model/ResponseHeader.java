package com.hotelreserve.http.model;


import com.hotelreserve.http.ConnectionMessage;

/**
 * Created by zouwei on 2018/4/17.
 */
public class ResponseHeader {
    public int code;
    public String msg;

    public ResponseHeader() {
        setServerError();
    }

    /**
     * 服务器错误
     */
    public void setServerError() {
        this.code = ConnectionMessage.SERVER_ERROR_CODE;
        this.msg = ConnectionMessage.SERVER_ERROR_TEXT;
    }

    /**
     * openid获取失败
     */
    public void setOpenidOrKeyError() {
        this.code = ConnectionMessage.SERVER_ERROR_CODE;
        this.msg = ConnectionMessage.OPENID_ERROR_TEXT;
    }
    /**
     * code为空
     */
    public void setCodeError() {
        this.code = ConnectionMessage.SERVER_ERROR_CODE;
        this.msg = ConnectionMessage.OPENID_ERROR_TEXT;
    }

    /**
     * 简单请求成功
     */
    public void setSuccess() {
        this.code = ConnectionMessage.SUCCESS_CODE;
        this.msg = ConnectionMessage.SUCCESS_TEXT;
    }
    /**
     * 简单请求成功
     */
    public void setAddSuccess() {
        this.code = ConnectionMessage.SUCCESS_CODE;
        this.msg = ConnectionMessage.ADD_SUCCESS_TEXT;
    }
    /**
     * 简单请求成功
     */
    public void setSuccessNoDate() {
        this.code = ConnectionMessage.SUCCESS_CODE;
        this.msg = ConnectionMessage.SUCCESS_TEXT;
    }


}
