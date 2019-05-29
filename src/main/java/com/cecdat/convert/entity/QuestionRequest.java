package com.cecdat.convert.entity;

public class QuestionRequest {

    private String openId;
    private String content;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "QuestionRequest{" +
                "openId='" + openId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
