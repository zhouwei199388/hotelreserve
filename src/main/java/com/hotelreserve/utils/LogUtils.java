package com.hotelreserve.utils;

import com.hotelreserve.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by zouwei on 2018/12/5.
 */
public class LogUtils {
    private static Logger logger = LoggerFactory.getLogger(LogUtils.class);

    public static void info(String text) {
        logger.info(text);
    }


}
