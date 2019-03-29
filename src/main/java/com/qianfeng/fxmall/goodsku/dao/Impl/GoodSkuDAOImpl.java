package com.qianfeng.fxmall.goodsku.dao.Impl;

import com.qianfeng.fxmall.commons.info.SystemConstantUtils;
import com.qianfeng.fxmall.goodsku.bean.WxbGoodSku;
import com.qianfeng.fxmall.goodsku.dao.IGoodSkuDAO;
import com.qianfeng.fxmall.goodsku.mapper.GoodSkuMapper;
import com.qianfeng.fxmall.commons.mybatis.MybatisSessionFactoryUtils;
import com.qianfeng.fxmall.commons.info.SystemConstantUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.InputStream;
import java.util.List;

public class GoodSkuDAOImpl implements IGoodSkuDAO {

    /*@Override
    public List<WxbGoodSku> queryGoodSkuByPage(Integer page) throws Exception{
        InputStream stream = Resources.getResourceAsStream("mabatis.cfg.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = sessionFactory.openSession();

        return null;
    }*/

    @Override
    public List<WxbGoodSku> queryGoodSkuByPage(Integer page) throws Exception {
        GoodSkuMapper goodSkuMapper = MybatisSessionFactoryUtils.getSession().getMapper(GoodSkuMapper.class);
        List<WxbGoodSku> goodSku = goodSkuMapper.queryGoodSkuByPage(page, SystemConstantUtils.Page.PAGE_SIZE);
        return goodSku;
    }
}
