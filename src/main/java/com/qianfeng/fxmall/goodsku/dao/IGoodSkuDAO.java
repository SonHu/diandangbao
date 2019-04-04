package com.qianfeng.fxmall.goodsku.dao;

import com.qianfeng.fxmall.goodsku.bean.WxbGoodSku;

import java.util.List;

public interface IGoodSkuDAO {

    List<WxbGoodSku> queryGoodSkuByPage(Integer page) throws Exception;

    void insertGoodSku(WxbGoodSku goodSku)throws Exception;
}
