package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.http.request.BindPhoneRequest;
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
    private String code = "023Ajsdj0fJ5jp1sWBcj0ByDdj0Ajsdg";
    private String encrypteDate = "3XttvxNswuFowyx117Jep5FmWGzvVmes8jdi9skYjUa3cFNeq07eui24hISgOQKzF66WcvEi+hAORFQ67cI7NZ9qIwTaln6KzHjl6RkldE4SAfVKjHnhcm9kzJSTa2I/Svch4eEcgVKhXSjIg/7XVpqPx2rpExrnmHIPlVwqlc+09uArTv9aZBdg4Ma1+b/4fhhMa18lAgG/8tznuxRuRDgbOX/+6tLN0ZXbYz0ZWZ/SNtthueEVnEU7d2IDRrgJNaaO9LuMrzvQ1F03+/k2pcSG2N+TYcDdZXkHBCorsWc0Ug5Cec7ZlN39IwklIVAb7Yf3OB9LRvNkgimA10c9zwI6zLYlWdU8q/bq7wnLL3jMfevOAH7WX10Kb7v++eGfBNwkJ2jR1loSgZKkMhpRj11do48VjkmeK7MdJMlavTg/nFZlftxxOE+iLjKbymRK4RUyPmcGmJmC80bZeOdKrQ==";
    private String iv = "/RmoQQMwXJ7uqBryQg0CnQ==";
    @Autowired
    protected WebApplicationContext wac;

    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @Test
    public void addUser() throws Exception {

        UserRequest userRequest = new UserRequest();
        userRequest.code = code;
        userRequest.encryptedData = encrypteDate;
        userRequest.iv = iv;
        String request = new Gson().toJson(userRequest);

        mvc.perform(MockMvcRequestBuilders.get("/user/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }


    @Test
    public void bindPhone() throws Exception {
        BindPhoneRequest bindPhoneRequest = new BindPhoneRequest();
        bindPhoneRequest.id = 8;
        bindPhoneRequest.phone = "15090824065";
        String request = new Gson().toJson(bindPhoneRequest);
        mvc.perform(MockMvcRequestBuilders.post("/user/bindPhone")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getUser() throws Exception {

    }

}