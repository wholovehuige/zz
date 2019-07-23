package com.nplat.convert.controller;

import com.nplat.convert.config.BaseResponse;
import com.nplat.convert.utils.LogUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileRestApi {


    @PostMapping("/upload")
    @ResponseBody
    public BaseResponse uploadFile(String queId, String openId, String title, String content, @RequestParam(value = "img", required = false) MultipartFile file) {
        String fileName = file.getOriginalFilename();
        StringBuilder builder = new StringBuilder("{\"queId\":");
        builder.append("\""+queId+"\"");
        builder.append(",\"openId\":");
        builder.append("\""+openId+"\"");
        builder.append(" ,\"title\":");
        builder.append("\""+title+"\"");
        builder.append(",\"content\":");
        builder.append("\""+content+"\"");
        builder.append(",\"fileName\"");
        builder.append("\""+fileName+"\"");
        builder.append("}");
        LogUtils.logAccessApi(builder.toString());
        return new BaseResponse(200);
    }

}
