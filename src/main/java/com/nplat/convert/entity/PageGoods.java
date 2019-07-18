package com.nplat.convert.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class PageGoods {

    Integer id;
    String userId;
    String gName;
    String gPrice;
    String originalPrice;
    String minPrice;
    String gImageUrl;
    Integer gStatus;
    Timestamp createDate;

}
