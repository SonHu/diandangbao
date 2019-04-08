package com.qianfeng.fxmall.goodsku.Service.Impl;

import com.qianfeng.fxmall.goodsku.bean.WxbGoodSku;

import java.util.List;

public interface IGoodSkuService {

      List<WxbGoodSku> queryGoodSkuByPage(Integer Page)throws Exception;

      void insertGoodSku(WxbGoodSku goodSku);
}
