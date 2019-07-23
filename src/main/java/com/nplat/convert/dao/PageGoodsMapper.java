package com.nplat.convert.dao;

import com.nplat.convert.entity.PageGoods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PageGoodsMapper {

    List<PageGoods> selectAll();

}