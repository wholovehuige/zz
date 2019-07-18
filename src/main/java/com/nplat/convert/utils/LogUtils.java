package com.nplat.convert.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by roy on 2019/2/18.
 */
public class LogUtils {

    public static final Logger ERROR_LOG = LoggerFactory.getLogger("convert-error");
    public static final Logger ACCESS_LOG = LoggerFactory.getLogger("convert-access");
    public static final Logger API_ACCESS_LOG = LoggerFactory.getLogger("api-access");

    public static void apiAccessLog(String msg) {
        API_ACCESS_LOG.info(msg);
    }

    public static void logAccessApi(String msg){
        ACCESS_LOG.info(msg);
    }

    public static void logErrorApi(String msg) {
        ERROR_LOG.info(msg);
    }

    public static void logErrorWithException(String msg,Exception e) {
        StringBuilder s = new StringBuilder();
        s.append(getBlock("exception"));
        s.append(getBlock(msg));
        ERROR_LOG.error(s.toString(), e);
    }
    private static String getBlock(Object msg) {
        if (msg == null) {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }

}
