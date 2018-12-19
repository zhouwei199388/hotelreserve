package com.hotelreserve.http.response;

import com.hotelreserve.http.model.RoomModel;
import com.hotelreserve.model.HotelRoom;
import com.hotelreserve.model.RoomImage;

import java.util.List;

/**
 * Created by zouwei on 2018/12/14.
 */
public class RoomResponse extends BaseResponse {
    public RoomModel room;
    public List<RoomModel> rooms;
}
