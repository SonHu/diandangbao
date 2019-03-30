package com.qianfeng.fxmall.goodsku.Service;

import com.qianfeng.fxmall.commons.info.SystemConstantUtils;
import com.qianfeng.fxmall.goodsku.Service.Impl.IGoodSkuService;
import com.qianfeng.fxmall.goodsku.bean.WxbGoodSku;
import com.qianfeng.fxmall.goodsku.dao.IGoodSkuDAO;
import com.qianfeng.fxmall.goodsku.dao.Impl.GoodSkuDAOImpl;

import java.util.List;

public class GoodSkuServiceImpl implements IGoodSkuService  {

    private IGoodSkuDAO goodSkuDAO = new GoodSkuDAOImpl();
    @Override
    public List<WxbGoodSku> queryGoodSkuByPage(Integer Page) throws Exception {
        if(Page < 1){
            throw new IndexOutOfBoundsException("页码数不能小于1");
        }
        //计算页码的下标
        int index = (Page - 1) * SystemConstantUtils.Page.PAGE_SIZE;
        List<WxbGoodSku> goodSkus = goodSkuDAO.queryGoodSkuByPage(index);
        return goodSkus;
    }
}
