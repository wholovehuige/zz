package com.cecdat.convert.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cecdat.convert.entity.QuestionRequest;
import com.cecdat.convert.service.WxGetParamService;
import com.cecdat.convert.utils.HttpUtils;
import com.cecdat.convert.utils.LogUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by roy on 2019/2/14.
 */
@Controller
public class HomePage {


    @RequestMapping(path = "/")
    public String toHomePage() {
        return "index";
    }

    String secret = "f7ee23b40c112fd2a296ecc95b0589a5";
    String appId = "wxe1a48f73244684be";

    @PostMapping(path = "/code2Session")
    @ResponseBody
    public String getOpenId(@RequestBody String code) {
        try {
            String codeStr = JSON.parseObject(code).getString("code");

            System.out.println("服务端接收的code是 ==   " + code);
            String res = HttpUtils.doGet(WxGetParamService.code2Session(appId, secret, codeStr));
            JSONObject jsonObject = JSONObject.parseObject(res);
            System.out.println(res);
            LogUtils.apiAccessLog(res);
//            String openId = jsonObject.getString("openid");
//            String sessionKey = jsonObject.getString("session_key");
//            System.out.println("换回的openid是 = " + openId);
//            //


            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }


    @PostMapping(path = "/formId")
    @ResponseBody
    public String testApi(@RequestBody String formId) {
        try {

            System.out.println("forId 是 =  " + formId);
            String access = HttpUtils.doGet(WxGetParamService.getAccessToken(appId, secret));
            JSONObject accessjsonObject = JSONObject.parseObject(access);
            String accessToken = accessjsonObject.getString("access_token");
//            String result  = HttpUtils.doGet(WxGetParamService.getPaidUnionId(accessToken,openId,null,null,null));
            JSONObject object = new JSONObject();
            object.put("touser", "olCoM0d_LEipHeV2_Qg8_bImA-Lk");
            object.put("template_id", "znZ5w_2LsVivac-_pyZtijN0XREzO2vFgCJWDqRGdxM");
            object.put("page", "index");
            object.put("form_id", formId);
            object.put("data", "\"keyword1\": {      \"value\": \"339208499\"    },    \"keyword2\": {      \"value\": \"2015年01月05日 12:30\"    },    \"keyword3\": {      value\": \"腾讯微信总部\"    },    \"keyword4\": {      \"value\": \"广州市海珠区新港中路397号\"    }");

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

    @GetMapping(path = "/getList")
    @ResponseBody
    public JSONArray testGetApi() {
        JSONArray array = new JSONArray();
        JSONObject object1 = new JSONObject();
        object1.put("title", "张老师");
        object1.put("image_url", "../../images/bars/zln.jpg");
        object1.put("description", "健康观念治疗联合发起人，拥有本公司课程代理和推广的权利，官方授权课程代理，请您放心");

        JSONObject object2 = new JSONObject();
        object2.put("title", "许大夫");
        object2.put("image_url", "../../images/bars/laotou.png");
        object2.put("description", "肾病专家，有着30多年中医诊疗经验，在肾小球坏死90%都可以完全治愈的老专家");
        array.add(object2);
        array.add(object1);

        return array;
    }


    @PostMapping(path = "/question")
    @ResponseBody
    public String question(@RequestBody QuestionRequest questionRequest) {
        try {

            System.out.println(questionRequest.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
