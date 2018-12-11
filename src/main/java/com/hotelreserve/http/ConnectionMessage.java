package com.hotelreserve.http;

/**
 * Created by zouwei on 2018/3/20.
 */
public class ConnectionMessage {
//    public static final String driver = "com.mysql.jdbc.Driver";
//    public static final String url = "jdbc:mysql://127.0.0.1:3306/testDemo";
//    public static final String shopUrl = "jdbc:mysql://127.0.0.1:3306/shop";
//    public static final String user = "root";
//    public static final String sqlPassWord = "zw199388";


    //返回类型
    public static final int SUCCESS_CODE = 0;//请求成功
    public static final int SERVER_ERROR_CODE = 1;//服务器错误
    public static final int TIME_OUT_CODE = 2;//超时


    public static final String SERVER_ERROR_TEXT = "服务器错误";
    public static final String OPENID_ERROR_TEXT = "openid获取失败";
    public static final String CODE_ERROR_TEXT = "code为空";
    public static final String SUCCESS_TEXT = "请求成功";
    public static final String ADD_SUCCESS_TEXT = "添加成功";
    public static final String HOTEL_IS_NULL = "酒店不存在";
    public static final String DELETE_SUCCESS_TEXT = "删除成功";
    public static final String UPDATE_SUCCESS_TEXT = "修改成功";
    public static final String BIND_SUCCESS_TEXT = "绑定手机号成功";
    public static final String REGISTER_SUCCESS_TEXT = "注册成功";
    public static final String USER_EXISTS = "用户已存在";

}
