package com.nplat.convert.controller;

import com.nplat.convert.config.BaseResponse;
import com.nplat.convert.entity.AskForEnterprise;
import com.nplat.convert.service.AskForEnterpriseService;
import com.nplat.convert.service.EnterpriseService;
import com.nplat.convert.service.MyPersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by roy on 2019/6/15.
 */
@Controller
public class MainPageRest {


    @Autowired
    private MyPersonInfoService infoService;

    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private AskForEnterpriseService askForEnterpriseService;

    @GetMapping(path = "/get/enterprise/info")
    @ResponseBody
    public BaseResponse enterpriseInfo(Integer personId) {
        BaseResponse response = new BaseResponse();
        response.setData(enterpriseService.getEnterpriseInfo(personId));
        return response;
    }

    @PostMapping(path = "/update/enterprise/info")
    @ResponseBody
    public BaseResponse update(Integer id,
                               Integer personId,
                               String sName,
                               String uName,
                               String sPhone,
                               String wxNumber,
                               String sAddress,
                               String openTime,
                               String sDescription,
                               @RequestParam(value = "img", required = false) MultipartFile sImage,
                               Double latitude,
                               Double longitude){
        BaseResponse response = new BaseResponse();
        try {
            enterpriseService.updateEnterpriseInfo(id, personId, sName, uName, sPhone, wxNumber, sAddress, openTime, sDescription, sImage, latitude, longitude);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping(path = "/apply/for_enterprise")
    @ResponseBody
    public BaseResponse askForEnterprise(Integer pid){
        BaseResponse response = new BaseResponse();
        response.setData(enterpriseService.createApplyEnterprise(pid));
        return response;
    }
    @GetMapping(path = "/get/for_enterprise/infos")
    @ResponseBody
    public BaseResponse getAskForEnterprise() {
        BaseResponse response = new BaseResponse();
        response.setData(askForEnterpriseService.getAskEnterprise());
        return response;
    }

    @PostMapping(path = "/check/ask_for_enterprise")
    @ResponseBody
    public BaseResponse checkEnterprise(Integer askId){
        BaseResponse response = new BaseResponse();
        response.setData(askForEnterpriseService.update(askId));
        return response;
    }

    @PostMapping(path = "/home/enterprise")
    @ResponseBody
    public BaseResponse enterpriseInfos(Double lat,Double lon,Integer page,Integer size) {

        BaseResponse response = new BaseResponse();
        response.setData(enterpriseService.getEnterpriseInfos(lat,lon,page,size));
        return response;
    }


}
