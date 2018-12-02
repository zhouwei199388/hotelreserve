package com.hotelreserve.controller;

import com.hotelreserve.model.User;
import com.hotelreserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 15090 on 2018/12/2.
 */

@Controller
@RequestMapping(value ="/user")
public class UserController {
    @Autowired
    private UserService mUserService;

    @ResponseBody
    @RequestMapping(value = "/add",produces = {"application/json;charset=UTF-8"})
    public void addUser( User user){
        int result = mUserService.addUser(user);
        System.out.print(result);
    }


}
