package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.response.AdminResponse;
import com.hotelreserve.model.Admin;
import com.hotelreserve.service.AdminService;
import com.hotelreserve.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by zouwei on 2018/12/12.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminService mAdminService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletResponse response,@RequestBody Admin admin) {
        AdminResponse adminResponse = mAdminService.loginAdmin(admin);
        ResponseUtils.renderJson(response,new Gson().toJson(adminResponse));
    }

    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addAdmin(HttpServletResponse response,@RequestBody Admin admin){
        ResponseHeader header =mAdminService.addAdmin(admin);
        ResponseUtils.renderJson(response,new Gson().toJson(header));
    }
}
