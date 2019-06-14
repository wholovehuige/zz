package com.cecdat.convert.entity;

public class PersonInfo {

    Integer id;
    String uName;
    String uImgUrl;
    String personalQrCode;
    Integer myFans;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuImgUrl() {
        return uImgUrl;
    }

    public void setuImgUrl(String uImgUrl) {
        this.uImgUrl = uImgUrl;
    }

    public String getPersonalQrCode() {
        return personalQrCode;
    }

    public void setPersonalQrCode(String personalQrCode) {
        this.personalQrCode = personalQrCode;
    }

    public Integer getMyFans() {
        return myFans;
    }

    public void setMyFans(Integer myFans) {
        this.myFans = myFans;
    }
}
