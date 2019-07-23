package com.nplat.convert.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PageGoods {
    private Long id;

    private String userId;

    private String gName;

    private BigDecimal gPrice;

    private BigDecimal originalPrice;

    private BigDecimal minPrice;

    private String gImageUrl;

    private Integer gStatus;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    public BigDecimal getgPrice() {
        return gPrice;
    }

    public void setgPrice(BigDecimal gPrice) {
        this.gPrice = gPrice;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public String getgImageUrl() {
        return gImageUrl;
    }

    public void setgImageUrl(String gImageUrl) {
        this.gImageUrl = gImageUrl == null ? null : gImageUrl.trim();
    }

    public Integer getgStatus() {
        return gStatus;
    }

    public void setgStatus(Integer gStatus) {
        this.gStatus = gStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}