package com.cecdat.convert.service;

import com.cecdat.convert.entity.Banners;
import com.cecdat.convert.entity.GoodsCategory;
import com.cecdat.convert.entity.PageGoods;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {

    public List<PageGoods> getPageGoods() {
        List<PageGoods> pageGoodsList = new ArrayList<>();
        for(int i = 0 ;i<12;i++) {
            PageGoods pageGoods1 = new PageGoods();
            pageGoods1.setId(i);
            pageGoods1.setgName("10-12岁袜子=="+i);
            pageGoods1.setMinPrice("12.8" + i);
            pageGoods1.setOriginalPrice("33.5" + i);
            pageGoods1.setgPrice("10.99" + i);
            pageGoods1.setgImageUrl("https://cdn.it120.cc/apifactory/2017/10/30/bc15e96f20fb13cc7d35f90d743ccb17.jpg");
            pageGoods1.setUserId("4352345");
            pageGoods1.setgStutas(1);
            pageGoodsList.add(pageGoods1);
        }
        return pageGoodsList;
    }

    public List<GoodsCategory> getGoodCategory() {
        List<GoodsCategory> categoryList = new ArrayList<>();
        GoodsCategory goodsCategory1 = new GoodsCategory();
        goodsCategory1.setId(1);
        goodsCategory1.setCnNme("上装");
        goodsCategory1.setIconRrl("https://cdn.it120.cc/apifactory/2019/04/09/f89753a227d26a3fe9ccc6f975857bb6.png");
        goodsCategory1.setIsUse("1");
        goodsCategory1.setUserId("95");
        categoryList.add(goodsCategory1);
        GoodsCategory goodsCategory2 = new GoodsCategory();
        goodsCategory2.setId(1);
        goodsCategory2.setCnNme("裤装");
        goodsCategory2.setIconRrl("https://cdn.it120.cc/apifactory/2019/04/09/5bfffd6ad0d4483870f024a3ed936528.png");
        goodsCategory2.setIsUse("1");
        goodsCategory2.setUserId("95");
        categoryList.add(goodsCategory2);

        GoodsCategory goodsCategory3 = new GoodsCategory();
        goodsCategory3.setId(1);
        goodsCategory3.setCnNme("家居内衣");
        goodsCategory3.setIconRrl("https://cdn.it120.cc/apifactory/2019/04/09/777b977a3415d6a3195f5e1e1059936a.png");
        goodsCategory3.setIsUse("1");
        goodsCategory3.setUserId("95");
        categoryList.add(goodsCategory3);

        GoodsCategory goodsCategory4 = new GoodsCategory();
        goodsCategory4.setId(1);
        goodsCategory4.setCnNme("特价区");
        goodsCategory4.setIconRrl("https://cdn.it120.cc/apifactory/2019/04/09/8d32c254e2cb86d2d42c99b768d136b6.png");
        goodsCategory4.setIsUse("1");
        goodsCategory4.setUserId("95");
        categoryList.add(goodsCategory4);

        GoodsCategory goodsCategory5 = new GoodsCategory();
        goodsCategory5.setId(1);
        goodsCategory5.setCnNme("特价区");
        goodsCategory5.setIconRrl("https://cdn.it120.cc/apifactory/2019/04/09/8d32c254e2cb86d2d42c99b768d136b6.png");
        goodsCategory5.setIsUse("1");
        goodsCategory5.setUserId("95");
        categoryList.add(goodsCategory5);

        return categoryList;
    }

    public List<Banners> banners(){
        List<Banners> bannersList = new ArrayList<>();
        Banners banners1 = new Banners();
        banners1.setId(1);
        banners1.setBusinessId("1");
        banners1.setPicUrl("https://cdn.it120.cc/apifactory/2019/03/18/7de640d0a0c0c3f525df0e6b65abb1f0.png");
        banners1.setStatus("1");
        Banners banners2 = new Banners();
        banners2.setId(1);
        banners2.setBusinessId("1");
        banners2.setPicUrl("https://cdn.it120.cc/apifactory/2019/03/18/4714a6caa0be3c4153b747562a4337b6.png");
        banners2.setStatus("1");
        Banners banners3 = new Banners();
        banners3.setId(1);
        banners3.setBusinessId("1");
        banners3.setPicUrl("https://cdn.it120.cc/apifactory/2019/03/18/c7c8e67ca1b6ff23efa13b5d7516a9d6.png");
        banners3.setStatus("1");
        bannersList.add(banners1);
        bannersList.add(banners2);
        bannersList.add(banners3);
        return bannersList;
    }


}
