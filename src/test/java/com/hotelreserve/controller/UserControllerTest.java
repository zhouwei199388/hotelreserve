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
    private String code = "0332Y2ne2I5XXG00nyme2oQ0ne22Y2nB";
    private String encrypteDate="J9HfdfyvtYZtZ1YA3s1BAXjZoWv0+gZViK98AXYaWVJnM8Egl+Hmkhw0s4nteqI+8sjgramNFDGjoRWg1EOpuJhFTL20NTe/q2mIlWqr3wTDbemDD009XRyBYy1U10nqHa9WhZNcGP4+hPRiSpmkkTmUfCcMNKvf/6ouBSX/fOdnhRPpO4Wup1SOYnJxGDe8Jy8CLUkv+Y9cPwDg8ACVk0g0RVvDCuoQAocFU0tGl0TxqAooDXmRRYZoHXhgrxjSA5I98IGVvcVfT1JaAwJfi4WuRdXsHOvvpsmVprWu6BtiR2jK26OJ2K0odEm5vgtD3KEaTXROXm3RisPSq9XAgzHyAxGwNejqRogGcW/Ws46oIn6bcEClWAzNQXcs3QAv2hOYWrXYpcXmMjoMvJuci/4dr1nKWRuj6MHgyWoBbpXqpnPb+Cm+VAXmpv5kyd0gEFBwMreRB8p6iGeyVnTdxg==";
    private String iv="scKoG/sNtBIhVA3iORwNFg==";
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