package com.nplat.convert.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * Created by roy on 2019/6/19.
 */
@Getter
@Setter
@TableName("ask_for_enterprise")
public class AskForEnterprise {
    Integer id;
    Integer personId;
    String nickName;
    String avataUrl;
    Integer enterpriseId;
    Integer status;
    Timestamp createDate;
}
