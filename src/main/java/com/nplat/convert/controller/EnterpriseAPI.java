package com.nplat.convert.controller;

import com.nplat.convert.basePackage.request.AgreeEnterpriseRequest;
import com.nplat.convert.basePackage.request.AskForEnterpriseRequest;
import com.nplat.convert.basePackage.request.EnterpriseInfoRequest;
import com.nplat.convert.basePackage.request.EnterpriseTypeRequest;
import com.nplat.convert.basePackage.request.NearEnperpriseRequest;
import com.nplat.convert.config.ApiMsgEnum;
import com.nplat.convert.config.BaseResponse;
import com.nplat.convert.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class EnterpriseAPI {
    @Autowired
    private EnterpriseService enterpriseService;

    //商户类型操作
    @PostMapping(path = "/enterprise/type")
    @ResponseBody
    public BaseResponse enterpriseType(@RequestBody EnterpriseTypeRequest request) {
        BaseResponse response = new BaseResponse();
        try {
            enterpriseService.createEnterpriseType(request.getName());
        } catch (Exception e) {
            e.printStackTrace();
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }
        return response;
    }

    //查询商户类型
    @GetMapping(path = "/enterprise/type")
    @ResponseBody
    public BaseResponse getEnterpriseType() {
        BaseResponse response = new BaseResponse();
        try {
            response.setData(enterpriseService.getEnterpriseType());
        } catch (Exception e) {
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }
        return response;
    }

    //申请成为商户
    @PostMapping(path = "/ask/enterprise")
    @ResponseBody
    public BaseResponse askForEnterprise(@RequestBody AskForEnterpriseRequest request) {
        BaseResponse response = new BaseResponse();
        try {
            enterpriseService.createApplyEnterprise(request.getPersonId(), request.getNickName(), request.getAvataUrl(), request.getReferenceId());
        } catch (Exception e) {
            e.printStackTrace();
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }
        return response;
    }


    //查看申请商户列表
    @GetMapping(path = "/ask/enterprise/infos/{id}")
    @ResponseBody
    public BaseResponse getAskEnterpriseInfo(@PathVariable("id") Long id) {
        BaseResponse response = new BaseResponse();
        try {
            response.setData(enterpriseService.searchAskEnterprises(id));
        } catch (Exception e) {
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }
        return response;
    }

    //同意商户申请
    @PostMapping(path = "/enterprise/agree")
    @ResponseBody
    public BaseResponse agreeEnterprise(@RequestBody AgreeEnterpriseRequest request) {
        BaseResponse response = new BaseResponse();
        try {
            enterpriseService.createInfoForEnterpriseInfo(request.getPersonId());
        } catch (Exception e) {
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }
        return response;
    }

    //查看商户信息
    @GetMapping(path = "/enterprise/info/{id}")
    @ResponseBody
    public BaseResponse getEnterpriseInfo(@PathVariable("id") Long id) {
        BaseResponse response = new BaseResponse();
        try {
            response.setData(enterpriseService.getEnterpriseInfoById(id));
        } catch (Exception e) {
            e.printStackTrace();
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }
        return response;
    }


    //修改商户信息
    @PostMapping(path = "/enterprise/info")
    @ResponseBody
    public BaseResponse updateEnterprise(@RequestBody EnterpriseInfoRequest request) {
        BaseResponse response = new BaseResponse();
        try {
            enterpriseService.updateEnterpriseInfo(request.getPersonId(),
                    request.getId(),request.getsType(),request.getsName(),request.getsPhone(),request.getImageFile(),request.getOpenTime(),
                    request.getWxNumber(),request.getsDescription(),request.getsAddress(),request.getLatitude(),request.getLongitude());
        } catch (Exception e) {
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }
        return response;
    }



    //修改商户信息
    @PostMapping(path = "/enterprise/infos")
    @ResponseBody
    public BaseResponse nearEnterprise(@RequestBody NearEnperpriseRequest request) {
        BaseResponse response = new BaseResponse();
        try {
            List<HashMap> nearEnterpriseList = enterpriseService.searchNearEnterprise(request.getCurrentPosition(),request.getSize(),request.getLatitude(),request.getLongitude());
            response.setData(nearEnterpriseList);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            response.setMsgEnum(ApiMsgEnum.INTERNAL_SERVER_ERROR);
            return response;
        }
    }
}
