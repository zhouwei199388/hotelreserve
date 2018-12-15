package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.model.HotelInfo;
import com.hotelreserve.model.HotelRoom;
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
public class RoomlControllerTest {
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
    public void addRoom() throws Exception {
        HotelRoom room = new HotelRoom();
        room.setHotelid(1);
        room.setName("标间");
        room.setPrice(258.00);
        room.setWindow(1);
        String request = new Gson().toJson(room);

        mvc.perform(MockMvcRequestBuilders.post("/room/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void updateRoom() throws Exception {
        HotelRoom room = new HotelRoom();
        room.setId(1);
        room.setHotelid(1);
        room.setName("大床房");
        room.setPrice(288.00);
        room.setWindow(1);
        String request = new Gson().toJson(room);
        mvc.perform(MockMvcRequestBuilders.post("/room/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getRooms() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/room/getAllRoom")
        .param("hotelId","1"))
                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void deleteRoom() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/room/delete")
                .contentType(MediaType.ALL)
                .param("roomId", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}