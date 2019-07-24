package com.nplat.convert.controller;

import com.nplat.convert.basePackage.request.GoodsRequest;
import com.nplat.convert.config.BaseResponse;
import com.nplat.convert.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoodsAPI {

    @Autowired
    private GoodsService goodsService;

    @PostMapping(path = "/good/info")
    @ResponseBody
    public BaseResponse uploadFile(@RequestBody GoodsRequest request) {
        BaseResponse response = new BaseResponse();
        try {
           Long goodId =  goodsService.createGoods(request.getPersonId(),
                   request.getbName(),
                   request.getbDesc(),
                   request.getbRealPrise(),
                   request.getbPrice(),
                   request.getLatitude(),
                   request.getLongitude(),
                   request.getGoodImages());
            response.setData(goodId);
            return response;
        }catch (Exception e) {
            e.printStackTrace();
            return response;
        }
    }

}
