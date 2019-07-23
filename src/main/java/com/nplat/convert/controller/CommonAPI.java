package com.nplat.convert.controller;


import com.nplat.convert.config.BaseResponse;
import com.nplat.convert.service.QiNiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CommonAPI {

    @Autowired
    private QiNiuService qiNiuService;

    @PostMapping(path = "/update/file")
    @ResponseBody
    public BaseResponse uploadFile(@RequestParam(value = "img", required = false) MultipartFile file ) {
        BaseResponse response = new BaseResponse();
        try {
           String res  = qiNiuService.uploadFile(file.getInputStream());
            response.setData(res);
            return response;
        }catch (Exception e) {
            e.printStackTrace();
            return response;
        }
    }


}
