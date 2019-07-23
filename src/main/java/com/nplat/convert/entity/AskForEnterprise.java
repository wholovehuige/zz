package com.nplat.convert.entity;

import java.util.Date;

public class AskForEnterprise {
    private Long id;

    private String personId;

    private String nickName;

    private String avataUrl;

    private Long status;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getAvataUrl() {
        return avataUrl;
    }

    public void setAvataUrl(String avataUrl) {
        this.avataUrl = avataUrl == null ? null : avataUrl.trim();
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}