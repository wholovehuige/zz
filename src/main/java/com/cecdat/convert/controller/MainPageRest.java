package com.cecdat.convert.controller;

import com.cecdat.convert.config.BaseResponse;
import com.cecdat.convert.service.MyPersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by roy on 2019/6/15.
 */
@Controller
public class MainPageRest {


    @Autowired
    private MyPersonInfoService infoService;


    @GetMapping(path = "/main/enterprise/info")
    @ResponseBody
    public BaseResponse enterpriseInfo(String personId) {
        System.out.println("获取商家id= " + personId);
        BaseResponse response = new BaseResponse();
        response.setData(infoService.getEnterpriseInfo());
        return response;

    }



}
