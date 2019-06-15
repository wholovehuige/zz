package com.cecdat.convert.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageGoods {

    Integer id;
    String gName;
    String gPrice;
    String originalPrice;
    String minPrice;
    String gImageUrl;
    Integer gStatus;
    String userId;


}
