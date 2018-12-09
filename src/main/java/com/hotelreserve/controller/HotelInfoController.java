package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.response.HotelInfosResponse;
import com.hotelreserve.model.HotelInfo;
import com.hotelreserve.service.HotelService;
import com.hotelreserve.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by zouwei on 2018/12/7.
 */
@Controller
@RequestMapping(value = "/hotelInfo")
public class HotelInfoController {
    @Autowired
    private HotelService mHotelService;

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public void getHotelInfoList(HttpServletResponse response) {
        HotelInfosResponse hotelInfosResponse = mHotelService.getHotelInfoList();
        ResponseUtils.renderJson(response,new Gson().toJson(hotelInfosResponse));
    }
    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public void addHotelInfo(HttpServletResponse response, @RequestBody HotelInfo hotelInfo){
        ResponseHeader responseHeader = mHotelService.insertHotelInfo(hotelInfo);
        ResponseUtils.renderJson(response,new Gson().toJson(responseHeader));
    }
}
