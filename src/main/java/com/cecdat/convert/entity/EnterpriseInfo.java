package com.cecdat.convert.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

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
    Integer likeNumber;
    Integer viewNumber;
    Date createDate;

}
