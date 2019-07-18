package com.nplat.convert.service;

import com.nplat.convert.entity.Banners;
import com.nplat.convert.entity.GoodsCategory;
import com.nplat.convert.entity.PageGoods;
import com.nplat.convert.mapper.BannersMapper;
import com.nplat.convert.mapper.GoodsCategoryMapper;
import com.nplat.convert.mapper.PageGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class HomeService {
    @Autowired
    private BannersMapper bannersMapper;
    @Autowired
    private PageGoodsMapper goodsMapper;
    @Autowired
    private GoodsCategoryMapper categoryMapper;

    public List<PageGoods> getPageGoods() {
        return goodsMapper.selectByMap(new HashMap<>());
    }

    public List<GoodsCategory> getGoodCategory() {
        return categoryMapper.selectByMap(new HashMap<>());
    }

    public List<Banners> banners(){
        List<Banners> bannersList = bannersMapper.selectByMap(new HashMap<>());
        return bannersList;
    }


}
