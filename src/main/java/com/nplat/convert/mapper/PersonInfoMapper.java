package com.nplat.convert.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.nplat.convert.entity.PersonInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/**
 * Created by roy on 2019/6/17.
 */
@Mapper
public interface PersonInfoMapper extends BaseMapper<PersonInfo> {

   PersonInfo getPersonInfo(HashMap hashMap);

   void updateInfoById(HashMap hashMap);

}
