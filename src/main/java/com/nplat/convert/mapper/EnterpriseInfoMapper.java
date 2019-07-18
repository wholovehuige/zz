package com.nplat.convert.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.nplat.convert.entity.EnterpriseInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * Created by roy on 2019/6/17.
 */
@Mapper
public interface EnterpriseInfoMapper extends BaseMapper<EnterpriseInfo> {

    List<EnterpriseInfo> getNearEnterpriseInfos(HashMap hashMap);

    void updateInfoById(HashMap hashMap);

}
