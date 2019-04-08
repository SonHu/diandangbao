package com.qianfeng.fxmall.goodsku.Service;

import com.qianfeng.fxmall.commons.info.SystemConstantUtils;
import com.qianfeng.fxmall.goodsku.Service.Impl.IGoodSkuService;
import com.qianfeng.fxmall.goodsku.bean.WxbGoodSku;
import com.qianfeng.fxmall.goodsku.dao.IGoodSkuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodSkuServiceImpl implements IGoodSkuService  {

   @Autowired
   private IGoodSkuDAO goodSkuDAO;

    @Override
    public void insertGoodSku(WxbGoodSku goodSku)  {
          goodSkuDAO.insertGoodSku(goodSku);
    }

    @Override
    public List<WxbGoodSku> queryGoodSkuByPage(Integer page) throws Exception {
        if(page < 1){
            throw new IndexOutOfBoundsException("页码数不能小于1");
        }
        //计算页码的下标
        int index = (page - 1) * SystemConstantUtils.Page.PAGE_SIZE;
        List<WxbGoodSku> goodSkus = goodSkuDAO.queryGoodSkuByPage(index);
        return goodSkus;
    }
}
