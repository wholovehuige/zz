package com.nplat.convert.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class PersonInfo {

    Integer id;
    String openId;
    Integer uLevel;
    String nickName;
    String avataUrl;
    Integer gender;
    String country;
    String province;
    String city;
    String personalQrCode;
    Integer myFans;
    String uPhoneNumber;
    Timestamp createDate;

}
