package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.http.request.BindPhoneRequest;
import com.hotelreserve.http.request.UserRequest;
import com.hotelreserve.model.HotelInfo;
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
public class HotelControllerTest {
    @Autowired
    private MockMvc mvc;
    //    private String host = "http://101.132.195.191:8080";
    @Autowired
    protected WebApplicationContext wac;

    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @Test
    public void addHotel() throws Exception {
        HotelInfo hotelInfo = new HotelInfo();
        hotelInfo.setHotelname("四季星酒店");
        hotelInfo.setHoteladdress("深圳市龙岗区布吉大道");
        hotelInfo.setPhone("0217-88888888");
        hotelInfo.setFacility("停车场 游泳池 健身房 wifi");
        hotelInfo.setHoteltext("四季星酒店是一家特色经典酒店");
        String request = new Gson().toJson(hotelInfo);

        mvc.perform(MockMvcRequestBuilders.post("/hotelInfo/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void updateHotel() throws Exception {
        HotelInfo hotelInfo = new HotelInfo();
        hotelInfo.setId(1);
        hotelInfo.setHotelname("四季星酒店");
        hotelInfo.setHoteladdress("深圳市龙岗区布吉大道");
        hotelInfo.setFacility("停车场 游泳池 健身房 wifi");
        hotelInfo.setHoteltext("四季星酒店是一家特色经典酒店");
        String request = new Gson().toJson(hotelInfo);
        mvc.perform(MockMvcRequestBuilders.post("/hotelInfo/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getHotelInfos() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hotelInfo/get"))
                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void deleteHotel() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/hotelInfo/delete")
                .contentType(MediaType.ALL)
                .param("id", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}