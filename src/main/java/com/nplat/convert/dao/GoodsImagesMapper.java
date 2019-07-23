package com.nplat.convert.dao;

import com.nplat.convert.entity.GoodsImages;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GoodsImagesMapper {
    int insert(GoodsImages record);

    int insertSelective(GoodsImages record);
}