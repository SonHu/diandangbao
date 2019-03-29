package com.qianfeng.fxmall.commons.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 封装sessionFactory
 */
public class MybatisSessionFactoryUtils {

    /**
     * 饿汉单利
     */
    public static SqlSessionFactory sqlSessionFactory ;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    static {
        initSessionFactory();
    }

    private static void initSessionFactory(){
        try {
            //1、配置文件只需要加载一次（全局）
            InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
            //2、全局唯一
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory == null) {
            initSessionFactory();
        }
        return sqlSessionFactory;
    }

    public static SqlSession getSession(){
        System.out.println(Thread.currentThread().getName());
        SqlSession session = threadLocal.get();
        if (session == null) {
            session = sqlSessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }
}
