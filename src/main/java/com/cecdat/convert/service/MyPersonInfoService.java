package com.cecdat.convert.service;

import com.cecdat.convert.entity.PersonInfo;
import org.springframework.stereotype.Service;

@Service
public class MyPersonInfoService {

    public PersonInfo getInfo() {
        PersonInfo info = new PersonInfo();
        info.setId(1);
        info.setuName("Roy");
        info.setuImgUrl("https://cdn.it120.cc/apifactory/2017/10/30/bc15e96f20fb13cc7d35f90d743ccb17.jpg");
        info.setMyFans(99);
        info.setPersonalQrCode("");
        return info;
    }

}
