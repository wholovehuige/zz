package com.nplat.convert.entity;

public class GoodsImages {
    private Long id;

    private String goodUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodUrl() {
        return goodUrl;
    }

    public void setGoodUrl(String goodUrl) {
        this.goodUrl = goodUrl == null ? null : goodUrl.trim();
    }
}