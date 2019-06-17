package com.cecdat.convert.service;

import com.cecdat.convert.entity.EnterpriseInfo;
import com.cecdat.convert.entity.PersonInfo;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class MyPersonInfoService {

    public PersonInfo getInfo() {
        PersonInfo info = new PersonInfo();
        info.setId(1);
        info.setOpenId("openId");
        info.setULevel(3);
        info.setUName("Roy");
        info.setUImgUrl("https://cdn.it120.cc/apifactory/2017/10/30/bc15e96f20fb13cc7d35f90d743ccb17.jpg");
        info.setPersonalQrCode("");
        info.setMyFans(99);
        info.setUPhoneNumber("13011120332");
        return info;
    }

    public EnterpriseInfo getEnterpriseInfo() {
        EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
        enterpriseInfo.setId(1);
        enterpriseInfo.setPersonId(1);
        enterpriseInfo.setSName("牛逼玩具店");
        enterpriseInfo.setUName("二蛋");
        enterpriseInfo.setSPhone("13011120332");
        enterpriseInfo.setSImage("https://cdn.it120.cc/apifactory/2017/10/30/bc15e96f20fb13cc7d35f90d743ccb17.jpg");
        enterpriseInfo.setWxNumber("wx_number001");
        enterpriseInfo.setSDescription("牛逼玩具店是专门卖玩具的");
        enterpriseInfo.setSAddress("西安市碑林区XXX街道");
        enterpriseInfo.setOpenTime("09:00-21:00");
        enterpriseInfo.setLatitude(39.987231);
        enterpriseInfo.setLongitude(116.329236);
        enterpriseInfo.setCreateDate(new Date(1560600271));
        return enterpriseInfo;
    }


}
