package com.cecdat.convert.entity;

public class PageGoods {

    Integer id;
    String gName;
    String gPrice;
    String originalPrice;
    String minPrice;
    String gImageUrl;
    Integer gStutas;
    String userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgPrice() {
        return gPrice;
    }

    public void setgPrice(String gPrice) {
        this.gPrice = gPrice;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getgImageUrl() {
        return gImageUrl;
    }

    public void setgImageUrl(String gImageUrl) {
        this.gImageUrl = gImageUrl;
    }

    public Integer getgStutas() {
        return gStutas;
    }

    public void setgStutas(Integer gStutas) {
        this.gStutas = gStutas;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
