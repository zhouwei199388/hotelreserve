package com.hotelreserve.service;

import com.hotelreserve.http.request.UserRequest;
import com.hotelreserve.http.response.UserResponse;
import com.hotelreserve.mapper.UserMapper;
import com.hotelreserve.model.User;
import com.hotelreserve.model.UserExample;
import com.hotelreserve.utils.LogUtils;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 15090 on 2018/12/2.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper mUserMapper;


    /**
     * 添加用户  如果用户已存在返回用户信息
     *
     * @param request 小程序code等信息
     * @return
     */
    public User addUser(UserRequest request) {
        UserResponse userResponse = new UserResponse();
        User user = new User();
        userResponse.user = user;
        LogUtils.info("addUser");
//        int id = mUserMapper.insertSelective(user);
//        if (id != 0) {
//            //TODO:通过微信小程序code等信息获取用户微信信息
//        }
        return user;
    }


    /**
     * 绑定手机号
     *
     * @param id    用户id
     * @param phone 手机号
     */
    public void bindPhone(int id, String phone) {
        User user = new User();
        user.setId(id);
        user.setPhone(phone);
        int result = mUserMapper.updateByPrimaryKeySelective(user);

    }


    /**
     * 测试
     *
     * @return
     */
    public List<User> getUser() {
        UserExample example = new UserExample();
        return mUserMapper.selectByExample(example);
    }

}
