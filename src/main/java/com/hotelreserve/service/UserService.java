package com.hotelreserve.service;

import com.hotelreserve.mapper.UserMapper;
import com.hotelreserve.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
