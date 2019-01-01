package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.response.OrderResponse;
import com.hotelreserve.model.Order;
import com.hotelreserve.service.OrderService;
import com.hotelreserve.utils.LogUtils;
import com.hotelreserve.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 15090 on 2018/12/29.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService mOrderService;
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addOrder(HttpServletResponse response, @RequestBody Order order){
        LogUtils.info(new Gson().toJson(order));
        OrderResponse orderResponse = mOrderService.addOrder(order);
        ResponseUtils.renderJson(response,new Gson().toJson(orderResponse));
    }

}
