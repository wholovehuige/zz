package com.cecdat.convert.entity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by roy on 2019/2/18.
 */
public enum ApiMsgEnum {
    OK(200, "OK"),
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout"),
    COMMON_SERVER_ERROR(10000, "COMMON_SERVER_ERROR"),
    USER_SERVER_ERROR(11000, "USER_SERVER_ERROR"),
    USER_REDIS_ERROR(11001, "USER_REDIS_ERROR"),
    PRODUCT_SERVER_ERROR(12000, "PRODUCT_SERVER_ERROR"),
    PRODUCT_PARAMETER_ERROR(12001, "PRODUCT_PARAMETER_ERROR"),
    PRODUCT_BOM_ERROR(12002, "PRODUCT_SERVER_ERROR"),
    ORDER_SERVER_ERROR(13000, "ORDER_SERVER_ERROR"),
    CUSTOMER_SERVER_ERROR(13000, "CUSTOMER_SERVER_ERROR"),
    HIVE_EXCEPTION(14000, "hive throw exception"),
    HIVE_TABLE_EXISTS(14001, "table already exists"),
    HIVE_CREATE_TABLE_FAILED(14002, "create table failed"),
    INPUT_ERROR(55, "input error"),
    FILE_ALREADY_EXISTS(90001,"file exists in HDFS");
    private int resCode;
    private String resDes;
    public static Map<Integer, String> apiMsgMap = new HashMap();

    private ApiMsgEnum(int code, String msg) {
        this.resCode = code;
        this.resDes = msg;
    }

    private static Map<Integer, String> getAll() {
        Map<Integer, String> retMap = new LinkedHashMap();
        ApiMsgEnum[] enumArr = values();
        ApiMsgEnum[] var2 = enumArr;
        int var3 = enumArr.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            ApiMsgEnum aEnum = var2[var4];
            retMap.put(aEnum.getResCode(), aEnum.getResDes());
        }

        return retMap;
    }

    public int getResCode() {
        return this.resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public String getResDes() {
        return this.resDes;
    }

    public void setResDes(String resDes) {
        this.resDes = resDes;
    }

    static {
        apiMsgMap = getAll();
    }
}
