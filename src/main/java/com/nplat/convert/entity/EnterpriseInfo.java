package com.nplat.convert.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * Created by roy on 2019/6/15.
 */

@Getter
@Setter
public class EnterpriseInfo {
    Integer id;
    Integer personId;
    String sName;
    String uName;
    String sPhone;
    String sImage;
    String openTime;
    String wxNumber;
    String sDescription;
    String sAddress;
    Double latitude;
    Double longitude;
    @TableField(exist = false)
    Integer distance;
    Integer likeNumber;
    Integer myPassed;
    Integer viewNumber;
    Integer status;
    Timestamp createDate;

}
