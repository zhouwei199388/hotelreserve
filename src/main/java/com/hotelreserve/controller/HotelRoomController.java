package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.request.RoomRequest;
import com.hotelreserve.http.response.HotelInfosResponse;
import com.hotelreserve.http.response.RoomResponse;
import com.hotelreserve.model.HotelInfo;
import com.hotelreserve.model.HotelRoom;
import com.hotelreserve.service.HotelRoomService;
import com.hotelreserve.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 15090 on 2018/12/14.
 */
@Controller
@RequestMapping(value = "/room" ,method = RequestMethod.POST)
public class HotelRoomController {


    @Autowired
    private HotelRoomService mRoomService;

    @ResponseBody
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public void addRoom(HttpServletResponse response, @RequestBody RoomRequest request){
        ResponseHeader header = mRoomService.addRoom(request);
        ResponseUtils.renderJson(response,new Gson().toJson(header
        ));
    }
    @ResponseBody
    @RequestMapping(value = "/getAllRoom", method = RequestMethod.GET)
    public void getHotelInfoList(HttpServletResponse response,int hotelId) {
        RoomResponse roomResponse = mRoomService.getRooms(hotelId);
        ResponseUtils.renderJson(response,new Gson().toJson(roomResponse));
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void updateHotelInfo(HttpServletResponse response,@RequestBody RoomRequest request){
        ResponseHeader header = mRoomService.updateRoom(request);
        ResponseUtils.renderJson(response,new Gson().toJson(header));
    }
    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public void updateHotelInfo(HttpServletResponse response,int roomId){
        ResponseHeader header = mRoomService.deleteRoom(roomId);
        ResponseUtils.renderJson(response,new Gson().toJson(header));
    }
}
