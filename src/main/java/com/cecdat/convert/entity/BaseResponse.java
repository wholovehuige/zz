package com.cecdat.convert.entity;

import java.io.Serializable;

/**
 * Created by roy on 2019/2/18.
 */
public class BaseResponse implements Serializable {
    protected int resCode;
    protected String resDes;
    protected Object data;

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

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BaseResponse() {
        this.resCode = ApiMsgEnum.OK.getResCode();
        this.resDes = ApiMsgEnum.OK.getResDes();
    }

    public BaseResponse(int code, String msg) {
        this.resCode = code;
        this.resDes = msg;
        this.data = "";
    }

    public BaseResponse(int code, Exception e) {
        this.resCode = code;
        this.resDes = e.getMessage();
        this.data = "";
    }

    public BaseResponse(int code, String msg, Exception e) {
        this.resCode = code;
        this.resDes = msg;
        this.data = "";
    }

    public BaseResponse(Object data) {
        this.resCode = ApiMsgEnum.OK.getResCode();
        this.resDes = ApiMsgEnum.OK.getResDes();
        this.data = data;
    }

    public BaseResponse(Exception exp) {
        this.resCode = 500;
        this.resDes = exp.getMessage();
        this.data = "";
    }

    public BaseResponse(ApiMsgEnum msgEnum) {
        this.resCode = msgEnum.getResCode();
        this.resDes = msgEnum.getResDes();
        this.data = "";
    }
}

