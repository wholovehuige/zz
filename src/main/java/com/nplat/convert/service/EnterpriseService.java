package com.nplat.convert.service;

import com.nplat.convert.entity.AskForEnterprise;
import com.nplat.convert.entity.EnterpriseInfo;
import com.nplat.convert.entity.PersonInfo;
import com.nplat.convert.mapper.AskForEnterpriseMapper;
import com.nplat.convert.mapper.EnterpriseInfoMapper;
import com.nplat.convert.mapper.PersonInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class EnterpriseService {
    @Autowired
    private EnterpriseInfoMapper enterpriseInfoMapper;
    @Autowired
    private AskForEnterpriseMapper askForEnterpriseMapper;
    @Autowired
    private PersonInfoMapper personInfoMapper;
    @Autowired
    private OSSOptionService ossOptionService;

    @Transactional
    public PersonInfo createApplyEnterprise(Integer pid) {
        PersonInfo personInfo = personInfoMapper.selectById(pid);
        HashMap hashMap = new HashMap();
        hashMap.put("id", pid);
        hashMap.put("uLevel", 1);
        personInfoMapper.updateInfoById(hashMap);
        Integer eId = createInfoForEnterpriseInfo(pid);
        AskForEnterprise askForEnterprise = new AskForEnterprise();
        askForEnterprise.setPersonId(pid);
        askForEnterprise = askForEnterpriseMapper.selectOne(askForEnterprise);
        if (askForEnterprise == null) {
            askForEnterprise = new AskForEnterprise();
            askForEnterprise.setPersonId(pid);
            askForEnterprise.setNickName(personInfo.getNickName());
            askForEnterprise.setAvataUrl(personInfo.getAvataUrl());
            askForEnterprise.setEnterpriseId(eId);
            askForEnterprise.setStatus(0);
            askForEnterpriseMapper.insert(askForEnterprise);
        }
        personInfo.setULevel(1);
        return personInfo;
    }

    public Integer createInfoForEnterpriseInfo(Integer pid) {
        EnterpriseInfo enterpriseInfo = getEnterpriseInfo(pid);
        if (enterpriseInfo == null) {
            enterpriseInfo = new EnterpriseInfo();
            enterpriseInfo.setPersonId(pid);
            enterpriseInfo.setLikeNumber(0);
            enterpriseInfo.setMyPassed(0);
            enterpriseInfo.setViewNumber(0);
            enterpriseInfo.setStatus(0);
            enterpriseInfoMapper.insert(enterpriseInfo);
            return enterpriseInfo.getId();
        } else {
            return enterpriseInfo.getId();
        }
    }

    @Transactional
    public void updateEnterpriseInfo(Integer id,
                                     Integer personId,
                                     String sName,
                                     String uName,
                                     String sPhone,
                                     String wxNumber,
                                     String sAddress,
                                     String openTime,
                                     String sDescription,
                                     MultipartFile imageFile,
                                     Double latitude,
                                     Double longitude) {
        try {
            String imageUrl = ossOptionService.setFileToOss(imageFile);
            HashMap info = new HashMap();
            info.put("id", personId);
            info.put("uLevel", 3);
            personInfoMapper.updateInfoById(info);
            HashMap hashMap = new HashMap();
            hashMap.put("id", id);
            hashMap.put("sName", sName);
            hashMap.put("uName", uName);
            hashMap.put("sPhone", sPhone);
            hashMap.put("wxNumber", wxNumber);
            hashMap.put("sAddress", sAddress);
            hashMap.put("openTime", openTime);
            hashMap.put("sDescription", sDescription);
            hashMap.put("sImage", imageUrl);
            hashMap.put("latitude", latitude);
            hashMap.put("longitude", longitude);
            enterpriseInfoMapper.updateInfoById(hashMap);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<EnterpriseInfo> getEnterpriseInfos(Double lat, Double lon,Integer page,Integer size) {
        Integer offset = page * size;
        HashMap hashMap = new HashMap();
        hashMap.put("latitude", lat);
        hashMap.put("longitude", lon);
        hashMap.put("offset", offset);
        hashMap.put("size", size);
        List<EnterpriseInfo> list=  enterpriseInfoMapper.getNearEnterpriseInfos(hashMap);
        System.out.println("lat="+lat +"    lon="+lon+"    page="+page+"  ==  size="+size +  "    total=" + list.size());
        return  list;
    }

    public EnterpriseInfo getEnterpriseInfo(Integer personId) {
        EnterpriseInfo info = new EnterpriseInfo();
        info.setPersonId(personId);
        return enterpriseInfoMapper.selectOne(info);
    }

}
