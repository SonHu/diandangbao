package com.qianfeng.fxmall.goodsku.mapper;

import com.qianfeng.fxmall.goodsku.bean.WxbGoodSku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodSkuMapper {

    //按页码查询
    List<WxbGoodSku> queryGoodSkuByPage(@Param("index") Integer index, @Param("size") Integer size);

    //增加
    void insertGoodSku(WxbGoodSku goodSku);

}

   /* @Param("skuName") String skuName,@Param("skuCost") String skuCost,@Param("skuPrice") String skuPrice,
    @Param("skuPmoney") String skuPmoney,@Param("goodId") String goodId,@Param("orderNo") Integer orderNo,
    @Param("serviceMoney") String serviceMoney*/