package com.nplat.convert.dao;

import com.nplat.convert.entity.GoodsCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsCategoryMapper {


    List<GoodsCategory> selectAll();


}