package com.nplat.convert.service;

import com.nplat.convert.dao.BannersMapper;
import com.nplat.convert.dao.GoodsCategoryMapper;
import com.nplat.convert.dao.PageGoodsMapper;
import com.nplat.convert.entity.Banners;
import com.nplat.convert.entity.GoodsCategory;
import com.nplat.convert.entity.PageGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return goodsMapper.selectAll();
    }

    public List<GoodsCategory> getGoodCategory() {
        return categoryMapper.selectAll();
    }

    public List<Banners> banners(){
        List<Banners> bannersList = bannersMapper.selectBanners();
        return bannersList;
    }


}
