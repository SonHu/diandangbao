package com.qianfeng.fxmall.goodsku.dao.Impl;

import com.qianfeng.fxmall.commons.info.SystemConstantUtils;
import com.qianfeng.fxmall.commons.mybatis.MybatisSessionFactoryUtils;
import com.qianfeng.fxmall.goodsku.bean.WxbGoodSku;
import com.qianfeng.fxmall.goodsku.dao.IGoodSkuDAO;
import com.qianfeng.fxmall.goodsku.mapper.GoodSkuMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodSkuDAOImpl implements IGoodSkuDAO {

    @Autowired
    private SqlSession session;
    /*@Override
    public List<WxbGoodSku> queryGoodSkuByPage(Integer page) throws Exception{
        InputStream stream = Resources.getResourceAsStream("mabatis.cfg.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = sessionFactory.openSession();

        return null;
    }*/

    /**
     * 按页码查询
     * @param page
     * @return
     * @throws Exception
     */
    @Override
    public List<WxbGoodSku> queryGoodSkuByPage(Integer page) throws Exception {
        GoodSkuMapper goodSkuMapper = MybatisSessionFactoryUtils.getSession().getMapper(GoodSkuMapper.class);
        List<WxbGoodSku> goodSku = goodSkuMapper.queryGoodSkuByPage(page, SystemConstantUtils.Page.PAGE_SIZE);
        return goodSku;
    }

    /**
     * 增加
     * @param goodSku
     * @throws Exception
     */
    @Override
    public void insertGoodSku(WxbGoodSku goodSku)  {
        /*GoodSkuMapper mapper = MybatisSessionFactoryUtils.getSession().getMapper(GoodSkuMapper.class);
        WxbGoodSku goodSku1 = new WxbGoodSku();
        goodSku1.getSkuPrice();
        goodSku1.getSkuPmoney();
        goodSku1.getGoodId();
        goodSku1.getOrderNo();
        goodSku1.getServiceMoney();
        goodSku1.getSkuCost();
        goodSku1.getSkuName();
        mapper.insertGoodSku(goodSku1);*/

        session.getMapper(GoodSkuMapper.class).insertGoodSku(goodSku);
        session.commit();
    }
}
