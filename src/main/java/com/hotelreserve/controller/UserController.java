package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.model.User;
import com.hotelreserve.service.UserService;
import com.hotelreserve.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 15090 on 2018/12/2.
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService mUserService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public void addUser(HttpServletResponse response, User user) {
        int result = mUserService.addUser(user);
        System.out.print(result);
        logger.info(user.toString());
        ResponseUtils.renderJson(response, new Gson().toJson(user));
    }


}
