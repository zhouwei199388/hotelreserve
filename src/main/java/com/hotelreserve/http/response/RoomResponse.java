package com.hotelreserve.http.response;

import com.hotelreserve.model.HotelRoom;

import java.util.List;

/**
 * Created by zouwei on 2018/12/14.
 */
public class RoomResponse extends BaseResponse {
    public HotelRoom room;
    public List<HotelRoom> rooms;
}
