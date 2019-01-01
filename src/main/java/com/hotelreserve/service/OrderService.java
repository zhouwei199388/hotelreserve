package com.hotelreserve.service;

import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.response.OrderResponse;
import com.hotelreserve.mapper.OrderMapper;
import com.hotelreserve.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 15090 on 2018/12/29.
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper mOrderMapper;

    public OrderResponse addOrder(Order order){
        OrderResponse response = new OrderResponse();
     ResponseHeader header = new ResponseHeader();
     int type = mOrderMapper.insert(order);
     if(type!=0){
         header.setSuccess();
     }
     response.header = header;
     return response;
    }
}
