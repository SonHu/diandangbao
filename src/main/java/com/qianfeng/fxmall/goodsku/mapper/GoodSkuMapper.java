package com.qianfeng.fxmall.goodsku.mapper;

import com.qianfeng.fxmall.goodsku.bean.WxbGoodSku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodSkuMapper {

    List<WxbGoodSku> queryGoodSkuByPage(@Param("index") Integer index, @Param("size") Integer size);
}
