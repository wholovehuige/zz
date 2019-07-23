package com.nplat.convert.dao;

import com.nplat.convert.entity.EnterpriseGoods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EnterpriseGoodsMapper {
    int insert(EnterpriseGoods record);

    int insertSelective(EnterpriseGoods record);
}