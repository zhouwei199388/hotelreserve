package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.request.BindPhoneRequest;
import com.hotelreserve.http.request.UserRequest;
import com.hotelreserve.http.response.UserResponse;
import com.hotelreserve.service.UserService;
import com.hotelreserve.utils.LogUtils;
import com.hotelreserve.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 15090 on 2018/12/2.
 */
@Controller
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService mUserService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(HttpServletResponse response, @RequestBody UserRequest request) {
        UserResponse user = mUserService.addUser(request);
        LogUtils.info(request.toString());
        ResponseUtils.renderJson(response, new Gson().toJson(user));
    }


    @RequestMapping(value = "/bindPhone", method = RequestMethod.POST)
    @ResponseBody
    public void bindPhone(@RequestBody BindPhoneRequest request, HttpServletResponse response) {
        LogUtils.info(request.toString());
        UserResponse userResponse = mUserService.bindPhone(request);
        LogUtils.info(new Gson().toJson(userResponse));
        ResponseUtils.renderJson(response, new Gson().toJson(userResponse));
    }
    @ResponseBody
    @RequestMapping(value = "/getAllUser" ,method = RequestMethod.GET)
    public void getAllUser(HttpServletResponse response){
        UserResponse userResponse = mUserService.getUserList();
        ResponseUtils.renderJson(response,new Gson().toJson(userResponse));
    }

    @ResponseBody
    @RequestMapping(value = "/sendVerifyCode" , method = RequestMethod.POST)
    public void sendVerifyCode(HttpServletResponse response,String phone,String code){
         LogUtils.info("phone: "+phone+"  code:  "+code);
         ResponseHeader header = mUserService.sendVerifycode(phone,code);
         ResponseUtils.renderJson(response,new Gson().toJson(header));
    }
}
