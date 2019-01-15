package com.hotelreserve.http.response;

import com.hotelreserve.http.model.OrderModel;
import com.hotelreserve.model.HotelInfo;
import com.hotelreserve.model.HotelRoom;
import com.hotelreserve.model.Order;

import java.util.List;

/**
 * Created by zouwei on 2019/1/12.
 */
public class OrderResponse extends BaseResponse {
    public List<OrderModel> orders;
}
