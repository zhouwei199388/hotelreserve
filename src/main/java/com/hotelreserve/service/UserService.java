package com.hotelreserve.service;

import com.hotelreserve.mapper.UserMapper;
import com.hotelreserve.model.User;
import com.hotelreserve.model.UserExample;
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

    public int addUser(User user){
        return mUserMapper.insertSelective(user);
    }

    public List<User> getUser(){
//        return mUserMapper.selectByPrimaryKey()
        UserExample example = new UserExample();
        return mUserMapper.selectByExample(example);
    }

}
