package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.http.request.UserRequest;
import com.hotelreserve.http.response.UserResponse;
import com.hotelreserve.model.User;
import com.hotelreserve.service.UserService;
import com.hotelreserve.utils.LogUtils;
import com.hotelreserve.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void addUser(HttpServletResponse response, @RequestBody UserRequest request) {
        UserResponse user = mUserService.addUser(request);
        LogUtils.info(request.toString());
        ResponseUtils.renderJson(response, new Gson().toJson(user));
    }

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public void getUser(HttpServletResponse response, HttpServletRequest request) {
        logger.info("getuser");
        List<User> users = mUserService.getUser();
        for (User user : users) {
            logger.info(user.toString());
        }
    }


}
