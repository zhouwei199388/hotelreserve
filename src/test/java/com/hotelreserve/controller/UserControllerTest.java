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
    private String code = "033OKtLk0LDfUq15uvLk04XPLk0OKtL6";
    private String encrypteDate="aE1FVNTFkKEF5DmQm3XO9fuVCZHNx0w98IJwH4/bYj8jkdxuuaAwyJhcZnNVGf+vx954B6bAjCoysR7Fz27EcGDS4PvEynRhcqLXLZFReHUC8vUowbO2IErcDCAOu41w7pyvCnRzJWiB3rSEZdTETZrLKZEV9+C/5LT3SlfnJqw9N5kEYCTZ+wTdX4N7VbOBJQPVFXWvu2yrSGloPUOPOu3DRVpMrNfdvhXqGkgZ+le66838lH75kdCRTJBob2s8LUYhUH4PtJgKlbCIF5et0XdRsA9xPStU/5mO3WuC4HFiRqffjjZlppc4oQTZ5Z/C/VR3Dt9v8Idn6V7Au06Ry56LUmClzZsKwwCCm405nHeJnqw1EzrvyNw9fSEZBdaRZ+SqqsKoDkIh94xV7maIZW6L0FxIZC9mvy524UjMyNuK0iuJ/gaz0Erk0kIswMhPfVZu9UTqTCiWgp/SIggIRA==";
    private String iv="l1MuKUU+80MTXnyx8cYLAw==";
    @Autowired
    protected WebApplicationContext wac;
    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @Test
    public void addUser() throws Exception {

        UserRequest userRequest = new UserRequest();
        userRequest.setCode(code);
        userRequest.setEncryptedData(encrypteDate);
        userRequest.setIv(iv);
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