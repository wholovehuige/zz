package com.nplat.convert.dao;

import com.nplat.convert.entity.GoodsImages;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GoodsImagesMapper {

    @Insert("insert into goods_images (good_url, good_id) values(#{goodUrl},#{goodId})")
    void insert(GoodsImages record);

}