package com.nplat.convert.entity;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class GoodsCategory {
    Integer id;
    String userId;
    String iconUrl;
    Integer status;
    String cnName;
    Timestamp createDate;


}
