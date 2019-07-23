package com.nplat.convert.dao;

import com.nplat.convert.entity.AskForEnterprise;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AskForEnterpriseMapper {


    @Insert("insert into ask_for_enterprise (person_id, nick_name,avata_url, status, create_date) values (#{personId}, #{nickName}, #{avataUrl}, #{status}, now() )")
    @Options(useGeneratedKeys = true,keyProperty ="id",keyColumn = "id")
    void createInfo(AskForEnterprise askForEnterprise);


    @Select("select id,person_id, nick_name,avata_url, status, create_date from  ask_for_enterprise where person_id = #{personId} ")
    AskForEnterprise selectByUserId(String personId);

    @Select("select id,person_id, nick_name,avata_url, status, create_date from  ask_for_enterprise where status = #{status} ")
    List<AskForEnterprise> selectAskByStatus(Long status);

}