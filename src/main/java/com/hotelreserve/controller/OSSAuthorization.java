package com.hotelreserve.controller;

import com.google.gson.Gson;
import com.hotelreserve.http.response.STSResponse;
import com.hotelreserve.service.AliStsService;
import com.hotelreserve.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 15090 on 2018/12/17.
 */
@Controller
@RequestMapping(value = "/api/OSS")
public class OSSAuthorization {
    @Autowired
    private AliStsService mAliStsService;
    @ResponseBody
    @RequestMapping(value = "/stsAuthorization",method = RequestMethod.POST)
    public void aliOSSAuthorization(HttpServletResponse response,String keyName){
        STSResponse STSResponse = mAliStsService.getAliSTS(keyName);
        ResponseUtils.renderJson(response,new Gson().toJson(STSResponse));
    }
}
