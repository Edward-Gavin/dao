package com.xiaokea.dao;

import com.xiaokea.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2019-09-24 15:19
 */
public class TestMybatis {



//    private InputStream in;
//    private SqlSession sqlSession;
//    private BaseDao userDao;
//
//    @Before
//    public void init() throws IOException {
//        //1. 读取配置文件
//        in = Resources.getResourceAsStream("mybatis-conf.xml");
//        //2. 使用
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        //3. 使用工厂生成sqlsession对象   // 使用了构建者模式，把对象的创建细节隐藏，使得使用者直接调用方法即可以拿到对象。
//        SqlSessionFactory factory = builder.build(in);
//        //4. 使用动态代理  // 生产SqlSession使用了工厂模式，
//        sqlSession = factory.openSession();
//        // 创建Dao接口实现类，使用了代理模式，指的是，在不修改源码的基础上，对已有方法增强
//        userDao = sqlSession.getMapper(BaseDao.class);
//    }
//
//    @After
//    public void destroy() throws IOException {
//
//        // 事物的提交
//        sqlSession.commit();
//        sqlSession.close();
//        in.close();
//    }

    @Test
    public void testUserDao() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-conf.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        BaseDao userDao = sqlSession.getMapper(BaseDao.class);

        User user = new User();
        user.setName("admin");
        user.setPassword("123456");
        List<User> userList = userDao.selectAll();
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }
}
