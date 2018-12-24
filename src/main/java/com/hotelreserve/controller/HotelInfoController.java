package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.http.model.HotelModel;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.response.HotelInfosResponse;
import com.hotelreserve.model.HotelInfo;
import com.hotelreserve.service.HotelService;
import com.hotelreserve.utils.LogUtils;
import com.hotelreserve.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addHotelInfo(HttpServletResponse response, @RequestBody HotelModel hotelModel){
        LogUtils.info(new Gson().toJson(hotelModel));
        ResponseHeader responseHeader = mHotelService.insertHotelInfo(hotelModel);
        ResponseUtils.renderJson(response,new Gson().toJson(responseHeader));
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void updateHotelInfo(HttpServletResponse response,@RequestBody HotelModel hotelModel){
        ResponseHeader header = mHotelService.updateHotelInfo(hotelModel);
        ResponseUtils.renderJson(response,new Gson().toJson(header));
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public void deleteHotelInfo(HttpServletResponse response, int id){
        ResponseHeader header = mHotelService.deleteHotelInfo(id);
        ResponseUtils.renderJson(response,new Gson().toJson(header));
    }
}
