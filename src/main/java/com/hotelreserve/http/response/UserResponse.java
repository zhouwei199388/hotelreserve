package com.hotelreserve.http.response;

import com.hotelreserve.http.model.UserModel;
import com.hotelreserve.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zouwei on 2018/12/5.
 * <p>
 * 用户返回体
 */
public class UserResponse extends BaseResponse {
    public UserModel user;
    public List<UserModel> users;


    public void formatUser(List<User> users) {
        for (User user : users) {
            UserModel userModel = new UserModel();
            userModel.copyFromUser(user);
            if(this.users==null){
                this.users = new ArrayList<>();
            }
            this.users.add(userModel);
        }
    }
}
