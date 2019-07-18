package com.nplat.convert.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@TableName("banners")
public class Banners {

    private Integer id;
    private String businessId;
    private String picUrl;
    private String status;
    private Timestamp createDate;
}
