package com.nplat.convert.service;

import com.nplat.convert.entity.PersonInfo;
import com.nplat.convert.mapper.EnterpriseInfoMapper;
import com.nplat.convert.mapper.PersonInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class MyPersonInfoService {
    @Autowired
    private PersonInfoMapper personInfoMapper;
    @Autowired
    private EnterpriseInfoMapper enterpriseInfoMapper;

    public Integer createPersonInfo(String openId) {
        PersonInfo info = getInfoByOpenId(openId);
        if(info == null) {
            info = new PersonInfo();
            info.setOpenId(openId);
            info.setULevel(0);
            info.setMyFans(0);
            personInfoMapper.insert(info);
            return info.getId();
        } else {
            return info.getId();
        }
    }

    public void updatePersonInfo(Integer id,
                                 Integer uLevel,
                                 String nickName,
                                 String avataUrl,
                                 Integer gender,
                                 String country,
                                 String province,
                                 String city,
                                 String personalQrCode,
                                 Integer fans,
                                 String uPhoneNumber) {
        HashMap hashMap = new HashMap();
        hashMap.put("id",id);
        hashMap.put("uLevel",uLevel);
        hashMap.put("nickName",nickName);
        hashMap.put("avataUrl",avataUrl);
        hashMap.put("gender",gender);
        hashMap.put("country",country);
        hashMap.put("province",province);
        hashMap.put("city",city);
        hashMap.put("personalQrCode",personalQrCode);
        hashMap.put("fans",fans);
        hashMap.put("uPhoneNumber",uPhoneNumber);
        personInfoMapper.updateInfoById(hashMap);
    }

    public PersonInfo getInfoById(Integer id) {
        HashMap hashMap = new HashMap();
        hashMap.put("id",id);
        return personInfoMapper.getPersonInfo(hashMap);
    }
    public PersonInfo getInfoByOpenId(String openId) {
        HashMap hashMap = new HashMap();
        hashMap.put("openId",openId);
        return personInfoMapper.getPersonInfo(hashMap);
    }




}
