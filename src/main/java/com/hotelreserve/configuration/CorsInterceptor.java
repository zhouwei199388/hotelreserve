//package com.hotelreserve.configuration;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by 15090 on 2018/12/9.
// */
//public class CorsInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception{
//
//        String origin = httpServletRequest.getHeader("Origin");
//        httpServletResponse.setHeader("Access-Control-Allow-Origin", origin);
//        httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
//        httpServletResponse.setHeader("Access-Control-Allow-Headers","Origin,Content-Type,Accept,token,X-Requested-With");
//        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
//
//        return true;
//    }
//}
