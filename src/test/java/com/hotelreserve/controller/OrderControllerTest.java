package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.model.Admin;
import com.hotelreserve.model.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * Created by zouwei on 2018/12/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class OrderControllerTest {
    @Autowired
    private MockMvc mvc;

    private String host = "http://101.132.195.191:8080";
    @Autowired
    protected WebApplicationContext wac;

    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @Test
    public void addOrder() throws Exception {
        Order order = new Order();
        order.setDays(2);
        order.setStartdate("2018-12-29");
        order.setEnddate("2018-12-31");
        order.setHotel("四季星酒店");
        order.setRoomnumber(1);
        order.setHotelroom("大床房");
        order.setPeople("邹维");
        order.setPhone("15090824065");
        order.setPrice(580.00);
        order.setStatus(0);
        order.setOrdernumber("1212442132164654");
        String request = new Gson().toJson(order);
        mvc.perform(MockMvcRequestBuilders.post("/order/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }


}