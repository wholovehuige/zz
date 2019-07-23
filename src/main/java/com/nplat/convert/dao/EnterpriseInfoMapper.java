package com.nplat.convert.dao;

import com.nplat.convert.entity.EnterpriseInfo;
import com.nplat.convert.provider.EnterpriseInfoProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Mapper
@Repository
public interface EnterpriseInfoMapper {



    @InsertProvider(type = EnterpriseInfoProvider.class ,method = "insert")
    @Options(useGeneratedKeys = true,keyProperty ="id",keyColumn = "id")
    int createInfo(EnterpriseInfo record);

    @UpdateProvider(type = EnterpriseInfoProvider.class ,method = "updateById")
    void updateInfoById(HashMap hashMap);

    @SelectProvider(type = EnterpriseInfoProvider.class ,method = "getPersonInfoByDynamic")
    EnterpriseInfo getEnterpriseInfoBy(HashMap hashMap);

}