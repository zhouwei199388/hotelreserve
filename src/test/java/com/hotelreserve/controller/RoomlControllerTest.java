package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.http.model.RoomModel;
import com.hotelreserve.http.request.RoomRequest;
import com.hotelreserve.model.HotelInfo;
import com.hotelreserve.model.HotelRoom;
import com.hotelreserve.model.RoomImage;
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

import java.util.ArrayList;
import java.util.List;


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

    public RoomModel getRoom(int id){
        RoomModel model = new RoomModel();
        if(id!=0){
            model.id = id;
        }
        model.hotelid=1;
        model.name="标间";
        model.price = 258.00;
        model.window = 1;
        List<RoomImage> roomImages = new ArrayList<>();
        for (int i=0;i<3;i++){
            RoomImage roomImage = new RoomImage();
            roomImage.setRoomid(1);
            roomImage.setName("test");
            roomImage.setUrl("https://hotelimage.oss-cn-shanghai.aliyuncs.com/hotel/9258356017_1215247113.400x400.jpg");
            roomImages.add(roomImage);
        }
        model.roomImages = roomImages;
        return model;
    }
    @Test
    public void addRoom() throws Exception {
        RoomModel request = getRoom(0);
        String requestJson = new Gson().toJson(request);
        mvc.perform(MockMvcRequestBuilders.post("/room/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void updateRoom() throws Exception {
        RoomModel request = getRoom(0);
        String requestJson = new Gson().toJson(request);
        mvc.perform(MockMvcRequestBuilders.post("/room/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getRooms() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/room/getAllRoom")
        .param("hotelId","10"))
                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void deleteRoom() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/room/delete")
                .contentType(MediaType.ALL)
                .param("roomId", "10"))
                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}