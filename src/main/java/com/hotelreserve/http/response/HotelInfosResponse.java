package com.hotelreserve.http.response;

import com.hotelreserve.model.HotelInfo;

import java.util.List;

/**
 * Created by zouwei on 2018/12/7.
 *
 * 酒店列表返回实体
 */
public class HotelInfosResponse extends BaseResponse{
    public List<HotelInfo> hotelInfos;
}
