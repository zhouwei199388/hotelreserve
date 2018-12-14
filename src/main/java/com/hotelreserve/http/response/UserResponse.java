package com.hotelreserve.http.response;

import com.hotelreserve.model.User;

import java.util.List;

/**
 * Created by zouwei on 2018/12/5.
 *
 * 用户返回体
 *
 */
public class UserResponse extends BaseResponse{
    public User user;
    public List<User> users;
}
