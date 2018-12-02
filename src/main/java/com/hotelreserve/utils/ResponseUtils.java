package com.hotelreserve.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zouwei on 2018/4/10.
 */
public class ResponseUtils {

    public static void renderJson(HttpServletResponse response, String text) {

        render(response, "text/plain;charset=UTF-8", text);
    }

    public static void render(HttpServletResponse response, String contentType, String text) {
        response.setContentType(contentType);
        response.setCharacterEncoding("utf-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        try {
            response.getWriter().write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
