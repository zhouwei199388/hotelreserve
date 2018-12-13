package com.hotelreserve.configuration;

import com.hotelreserve.utils.LogUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by 15090 on 2018/12/9.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        LogUtils.info("addCorsMappings");
        registry.addMapping("/**")//设置允许跨域的路径
                .allowedOrigins("*")//设置允许跨域请求的域名
                .allowCredentials(false)//是否允许证书 不再默认开启
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")//设置允许的方法
                .maxAge(3600);//跨域允许时间
    }
}
