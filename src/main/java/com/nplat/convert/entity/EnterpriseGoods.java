package com.nplat.convert.entity;

import java.math.BigDecimal;
import java.util.Date;

public class EnterpriseGoods {
    private Long id;

    private Long enterpriseId;

    private String bName;

    private String bDesc;

    private BigDecimal bRealPrise;

    private BigDecimal bPrice;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public String getbDesc() {
        return bDesc;
    }

    public void setbDesc(String bDesc) {
        this.bDesc = bDesc == null ? null : bDesc.trim();
    }

    public BigDecimal getbRealPrise() {
        return bRealPrise;
    }

    public void setbRealPrise(BigDecimal bRealPrise) {
        this.bRealPrise = bRealPrise;
    }

    public BigDecimal getbPrice() {
        return bPrice;
    }

    public void setbPrice(BigDecimal bPrice) {
        this.bPrice = bPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}