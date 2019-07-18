package com.nplat.convert.controller;


import com.alibaba.fastjson.JSONObject;
import com.nplat.convert.config.BaseResponse;
import com.nplat.convert.service.HomeService;
import com.nplat.convert.service.MyPersonInfoService;
import com.nplat.convert.service.WxGetParamService;
import com.nplat.convert.utils.HttpUtils;
import com.nplat.convert.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by roy on 2019/2/14.
 */
@Controller
public class HomePage {

    @Autowired
    private HomeService homeService;
    @Autowired
    private MyPersonInfoService infoService;
    @Value("${weChat.appId}")
    private String appId;
    @Value("${weChat.secret}")
    private String secret;


    @PostMapping(path = "/user/code2Session")
    @ResponseBody
    public BaseResponse RegisterAndGetOpenId(String code) {
        BaseResponse response = new BaseResponse();
        try {
            Integer id = null;
            String res = HttpUtils.doGet(WxGetParamService.code2Session(appId, secret, code));
            JSONObject jsonObject = JSONObject.parseObject(res);
            int errCode = jsonObject.getIntValue("errcode");
            String openId = jsonObject.getString("openid");
            String session_key = jsonObject.getString("session_key");
            if (openId != null) {
                id = infoService.createPersonInfo(openId);
            } else if (errCode == 40029) {
                id = infoService.createPersonInfo("openId");
            }
            LogUtils.apiAccessLog(res);
            response.setData(id);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }


    @PostMapping(path = "/user/formId")
    @ResponseBody
    public String testApi( String formId) {
        try {

            System.out.println("forId 是 =  " + formId);
            String access = HttpUtils.doGet(WxGetParamService.getAccessToken(appId, secret));
            JSONObject accessjsonObject = JSONObject.parseObject(access);
            String accessToken = accessjsonObject.getString("access_token");
            JSONObject object = new JSONObject();
            object.put("access_token", accessToken);
            object.put("touser", "olCoM0d_LEipHeV2_Qg8_bImA-Lk");
            object.put("template_id", "znZ5w_2LsVivac-_pyZtijN0XREzO2vFgCJWDqRGdxM");
            object.put("page", "pages/main/main");
            object.put("form_id", formId);

            JSONObject data = new JSONObject();
            JSONObject object1 = new JSONObject();
            object1.put("value", "339208499");
            data.put("keyword1", object1);
            JSONObject object2 = new JSONObject();
            object2.put("value", "2015年01月05日 12:30");
            data.put("keyword2", object2);
            JSONObject object3 = new JSONObject();
            object3.put("value", "腾讯微信总部");
            data.put("keyword3", object3);
            JSONObject object4 = new JSONObject();
            object4.put("value", "广州市海珠区新港中路397号");
            data.put("keyword4", object4);
            object.put("data", data);
            String url = WxGetParamService.send(accessToken);
            System.out.println(url);
            String result = HttpUtils.httpPostSend(url, object.toString());

            System.out.println(result);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }





    @GetMapping(path = "/banner/swiper")
    @ResponseBody
    public BaseResponse banner() {
        BaseResponse response = new BaseResponse();
        try {
            response.setData(homeService.banners());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping(path = "/shop/goods/category/all")
    @ResponseBody
    public BaseResponse category() {
        BaseResponse response = new BaseResponse();
        try {
            response.setData(homeService.getGoodCategory());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping(path = "/shop/goods/list")
    @ResponseBody
    public BaseResponse goodList() {
        BaseResponse response = new BaseResponse();
        try {
            response.setData(homeService.getPageGoods());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping(path = "/get/user/person")
    @ResponseBody
    public BaseResponse getPersonInfo(Integer id) {
        BaseResponse response = new BaseResponse();
        try {
            response.setData(infoService.getInfoById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }


    @PostMapping(path = "/update/user/person")
    @ResponseBody
    public BaseResponse updatePersonInfo(Integer id,
                                         Integer uLevel,
                                         String avatarUrl,
                                         String city,
                                         String province,
                                         String country,
                                         Integer gender,
                                         String nickName,
                                         String personalQrCode,
                                         Integer fans,
                                         String uPhoneNumber) {
        BaseResponse response = new BaseResponse();
        infoService.updatePersonInfo(id,uLevel,nickName,avatarUrl,gender,country,province,city,personalQrCode,fans,uPhoneNumber);
        return response;
    }


}
