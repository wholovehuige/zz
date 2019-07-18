package com.nplat.convert.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.nplat.convert.config.res.AskResponse;
import com.nplat.convert.entity.AskForEnterprise;
import com.nplat.convert.mapper.AskForEnterpriseMapper;
import com.nplat.convert.mapper.EnterpriseInfoMapper;
import com.nplat.convert.mapper.PersonInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by roy on 2019/6/20.
 */
@Service
public class AskForEnterpriseService {
    @Autowired
    private AskForEnterpriseMapper askForEnterpriseMapper;
    @Autowired
    private PersonInfoMapper personInfoMapper;
    @Autowired
    private EnterpriseInfoMapper enterpriseInfoMapper;

    public List<AskResponse> getAskEnterprise() {
        List<AskResponse> askResponseList = new ArrayList<>();
        EntityWrapper<AskForEnterprise> wrapper = new EntityWrapper<AskForEnterprise>();
        wrapper.where("status={0}",0).orderBy("create_date");
        List<AskForEnterprise> askForEnterpriseList = askForEnterpriseMapper.selectList(wrapper);
        for(AskForEnterprise enterprise : askForEnterpriseList ) {
            AskResponse response = new AskResponse();
            response.setId(enterprise.getId());
            response.setAvataUrl(enterprise.getAvataUrl());
            response.setCreateDate(enterprise.getCreateDate().toString().substring(0,enterprise.getCreateDate().toString().length()-2));
            response.setEnterpriseId(enterprise.getEnterpriseId());
            response.setStatus(enterprise.getStatus());
            response.setNickName(enterprise.getNickName());
            response.setPersonId(enterprise.getPersonId());
            askResponseList.add(response);
        }
        return askResponseList;
    }

    @Transactional
    public List<AskResponse> update(Integer askId) {
        AskForEnterprise askForEnterprise = askForEnterpriseMapper.selectById(askId);
        askForEnterprise.setStatus(1);
        askForEnterpriseMapper.updateById(askForEnterprise);
        HashMap enHash = new HashMap();
        enHash.put("id",askForEnterprise.getEnterpriseId());
        enHash.put("status",1);
        enterpriseInfoMapper.updateInfoById(enHash);
        HashMap hashMap = new HashMap();
        hashMap.put("id",askForEnterprise.getPersonId());
        hashMap.put("uLevel",2);
        personInfoMapper.updateInfoById(hashMap);
        return getAskEnterprise();
    }


}
