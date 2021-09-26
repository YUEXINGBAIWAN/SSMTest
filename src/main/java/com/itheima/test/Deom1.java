package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author shkstart
 * @create 2021-09-26 11:09
 */
public class Deom1 {
    @Test
    public void test() throws Exception {
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlsSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //调用查询方法
        for (Account account : dao.findAll()) {
            System.out.println(account);
        }

//        //提交数据
//        session.commit();
        //释放资源
        session.close();
        in.close();

    }

    @Test
    public void run2() throws Exception {
        Account account = new Account();
        account.setName("熊三");
        account.setMoney(400d);
// 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
// 创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
// 创建sqlSession对象
        SqlSession session = factory.openSession();
// 获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        dao.saveAccount(account);
// 提交事务
//        session.commit();
// 释放资源
        session.close();
        inputStream.close();
    }

}
