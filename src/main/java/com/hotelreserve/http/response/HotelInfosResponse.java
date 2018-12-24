package com.hotelreserve.http.response;

import com.hotelreserve.http.model.HotelModel;
import com.hotelreserve.http.model.RoomModel;
import com.hotelreserve.model.HotelInfo;

import java.util.List;

/**
 * Created by zouwei on 2018/12/7.
 *
 * 酒店列表返回实体
 */
public class HotelInfosResponse extends BaseResponse{
    public HotelModel hotelModel;
    public List<HotelModel> hotelModels;
}
