package com.cecdat.convert.service;

import com.cecdat.convert.entity.EnterpriseInfo;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnterpriseService {

    public List<EnterpriseInfo> getEnterpriseInfos() {
        List<EnterpriseInfo> enterpriseInfoList = new ArrayList<>();
        EnterpriseInfo enterpriseInfo1 = new EnterpriseInfo();
        enterpriseInfo1.setId(1);
        enterpriseInfo1.setPersonId(1);
        enterpriseInfo1.setSName("保定");
        enterpriseInfo1.setUName("二蛋");
        enterpriseInfo1.setSPhone("13011120332");
        enterpriseInfo1.setSImage("https://cdn.it120.cc/apifactory/2017/10/30/bc15e96f20fb13cc7d35f90d743ccb17.jpg");
        enterpriseInfo1.setWxNumber("wx_number001");
        enterpriseInfo1.setSDescription("牛逼玩具店是专门卖玩具的");
        enterpriseInfo1.setSAddress("西安市碑林区XXX街道");
        enterpriseInfo1.setOpenTime("09:00-21:00");
        enterpriseInfo1.setLatitude(115.557124);
        enterpriseInfo1.setLongitude(38.85349);

        enterpriseInfo1.setLikeNumber(15);
        enterpriseInfo1.setViewNumber(100);
        enterpriseInfo1.setCreateDate(new Date(1560600271));
        enterpriseInfoList.add(enterpriseInfo1);


        EnterpriseInfo enterpriseInfo2 = new EnterpriseInfo();
        enterpriseInfo2.setId(1);
        enterpriseInfo2.setPersonId(1);
        enterpriseInfo2.setSName("北京市1");
        enterpriseInfo2.setUName("二蛋");
        enterpriseInfo2.setSPhone("13011120332");
        enterpriseInfo2.setSImage("https://cdn.it120.cc/apifactory/2017/10/30/bc15e96f20fb13cc7d35f90d743ccb17.jpg");
        enterpriseInfo2.setWxNumber("wx_number001");
        enterpriseInfo2.setSDescription("牛逼玩具店是专门卖玩具的");
        enterpriseInfo2.setSAddress("西安市碑林区XXX街道");
        enterpriseInfo2.setOpenTime("09:00-21:00");
        enterpriseInfo2.setLatitude(39.894073);
        enterpriseInfo2.setLongitude(116.407999);
        enterpriseInfo2.setLikeNumber(15);
        enterpriseInfo2.setViewNumber(100);
        enterpriseInfo2.setCreateDate(new Date(1560600271));
        enterpriseInfoList.add(enterpriseInfo2);

        EnterpriseInfo enterpriseInfo3 = new EnterpriseInfo();
        enterpriseInfo3.setId(1);
        enterpriseInfo3.setPersonId(1);
        enterpriseInfo3.setSName("海淀区1");
        enterpriseInfo3.setUName("二蛋");
        enterpriseInfo3.setSPhone("13011120332");
        enterpriseInfo3.setSImage("https://cdn.it120.cc/apifactory/2017/10/30/bc15e96f20fb13cc7d35f90d743ccb17.jpg");
        enterpriseInfo3.setWxNumber("wx_number001");
        enterpriseInfo3.setSDescription("牛逼玩具店是专门卖玩具的");
        enterpriseInfo3.setSAddress("西安市碑林区XXX街道");
        enterpriseInfo3.setOpenTime("09:00-21:00");
        enterpriseInfo3.setLatitude(39.973078);
        enterpriseInfo3.setLongitude(116.313425);
        enterpriseInfo3.setLikeNumber(15);
        enterpriseInfo3.setViewNumber(100);
        enterpriseInfo3.setCreateDate(new Date(1560600271));
        enterpriseInfoList.add(enterpriseInfo3);


        EnterpriseInfo enterpriseInfo4 = new EnterpriseInfo();
        enterpriseInfo4.setId(1);
        enterpriseInfo4.setPersonId(1);
        enterpriseInfo4.setSName("石家庄");
        enterpriseInfo4.setUName("二蛋");
        enterpriseInfo4.setSPhone("13011120332");
        enterpriseInfo4.setSImage("https://cdn.it120.cc/apifactory/2017/10/30/bc15e96f20fb13cc7d35f90d743ccb17.jpg");
        enterpriseInfo4.setWxNumber("wx_number001");
        enterpriseInfo4.setSDescription("牛逼玩具店是专门卖玩具的");
        enterpriseInfo4.setSAddress("西安市碑林区XXX街道");
        enterpriseInfo4.setOpenTime("09:00-21:00");
        enterpriseInfo4.setLatitude(38.072369);
        enterpriseInfo4.setLongitude(114.646458);
        enterpriseInfo4.setLikeNumber(15);
        enterpriseInfo4.setViewNumber(100);
        enterpriseInfo4.setCreateDate(new Date(1560600271));
        enterpriseInfoList.add(enterpriseInfo4);

        EnterpriseInfo enterpriseInfo5 = new EnterpriseInfo();
        enterpriseInfo5.setId(1);
        enterpriseInfo5.setPersonId(1);
        enterpriseInfo5.setSName("海淀区2");
        enterpriseInfo5.setUName("二蛋");
        enterpriseInfo5.setSPhone("13011120332");
        enterpriseInfo5.setSImage("https://cdn.it120.cc/apifactory/2017/10/30/bc15e96f20fb13cc7d35f90d743ccb17.jpg");
        enterpriseInfo5.setWxNumber("wx_number001");
        enterpriseInfo5.setSDescription("牛逼玩具店是专门卖玩具的");
        enterpriseInfo5.setSAddress("西安市碑林区XXX街道");
        enterpriseInfo5.setOpenTime("09:00-21:00");
        enterpriseInfo5.setLatitude(39.987231);
        enterpriseInfo5.setLongitude(116.329236);
        enterpriseInfo5.setLikeNumber(15);
        enterpriseInfo5.setViewNumber(100);
        enterpriseInfo5.setCreateDate(new Date(1560600271));
        enterpriseInfoList.add(enterpriseInfo5);

        EnterpriseInfo enterpriseInfo6 = new EnterpriseInfo();
        enterpriseInfo6.setId(1);
        enterpriseInfo6.setPersonId(1);
        enterpriseInfo6.setSName("昌平");
        enterpriseInfo6.setUName("二蛋");
        enterpriseInfo6.setSPhone("13011120332");
        enterpriseInfo6.setSImage("https://cdn.it120.cc/apifactory/2017/10/30/bc15e96f20fb13cc7d35f90d743ccb17.jpg");
        enterpriseInfo6.setWxNumber("wx_number001");
        enterpriseInfo6.setSDescription("牛逼玩具店是专门卖玩具的");
        enterpriseInfo6.setSAddress("西安市碑林区XXX街道");
        enterpriseInfo6.setOpenTime("09:00-21:00");
        enterpriseInfo6.setLatitude(40.009561);
        enterpriseInfo6.setLongitude(116.36718);
        enterpriseInfo6.setLikeNumber(15);
        enterpriseInfo6.setViewNumber(100);
        enterpriseInfo6.setCreateDate(new Date(1560600271));
        enterpriseInfoList.add(enterpriseInfo6);

        EnterpriseInfo enterpriseInfo7 = new EnterpriseInfo();
        enterpriseInfo7.setId(1);
        enterpriseInfo7.setPersonId(1);
        enterpriseInfo7.setSName("天津");
        enterpriseInfo7.setUName("二蛋");
        enterpriseInfo7.setSPhone("13011120332");
        enterpriseInfo7.setSImage("https://cdn.it120.cc/apifactory/2017/10/30/bc15e96f20fb13cc7d35f90d743ccb17.jpg");
        enterpriseInfo7.setWxNumber("wx_number001");
        enterpriseInfo7.setSDescription("牛逼玩具店是专门卖玩具的");
        enterpriseInfo7.setSAddress("西安市碑林区XXX街道");
        enterpriseInfo7.setOpenTime("09:00-21:00");
        enterpriseInfo7.setLatitude(39.133462);
        enterpriseInfo7.setLongitude(117.315575);
        enterpriseInfo7.setLikeNumber(15);
        enterpriseInfo7.setViewNumber(100);
        enterpriseInfo7.setCreateDate(new Date(1560600271));
        enterpriseInfoList.add(enterpriseInfo7);
        return enterpriseInfoList;
    }

}
