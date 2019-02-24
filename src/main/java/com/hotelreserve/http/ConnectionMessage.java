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


    //订单状态
    public static final int  UNPAID = 0;//待支付
    public static final int  HAVEPAID = 1;//已支付
    public static final int  PAY_TIMEOUT = 2;//支付超时
    public static final int  CANCEL = 3;//已取消


    public static final String SERVER_ERROR_TEXT = "服务器错误";
    public static final String OPENID_ERROR_TEXT = "openid获取失败";
    public static final String CODE_ERROR_TEXT = "code为空";
    public static final String SUCCESS_TEXT = "请求成功";
    public static final String ADD_SUCCESS_TEXT = "添加成功";
    public static final String ADD_FAIL_TEXT = "添加失败";
    public static final String HOTEL_IS_NULL = "酒店不存在";
    public static final String HOTELROOM_IS_NULL = "房间不存在";
    public static final String DELETE_SUCCESS_TEXT = "删除成功";
    public static final String DELETE_FAIL_TEXT = "删除失败";
    public static final String UPDATE_SUCCESS_TEXT = "修改成功";
    public static final String LOGIN_SUCCESS_TEXT = "登录成功";
    public static final String LOGIN_FAIL_TEXT = "账号或密码错误";
    public static final String BIND_SUCCESS_TEXT = "绑定手机号成功";
    public static final String DATA_IS_NULL = "数据库暂无数据";
    public static final String BUCKET_FILE_ISEXIT = "bucket文件不存在";
    public static final String USER_EXISTS = "用户已存在";
    public static final String USER_NOT_EXISTS = "用户不存在";
}
