package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.http.request.UserRequest;
import org.junit.Assert;
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
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    protected WebApplicationContext wac;
    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @Test
    public void addUser() throws Exception {

        UserRequest userRequest = new UserRequest();
        userRequest.setCode("sldkjfl");
        userRequest.setKey("sldkfjsl");
        String request = new Gson().toJson(userRequest);

        mvc.perform(MockMvcRequestBuilders.get("/user/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getUser() throws Exception {

    }

}