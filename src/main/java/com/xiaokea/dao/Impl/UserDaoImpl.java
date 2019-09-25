package com.xiaokea.dao.Impl;

import com.xiaokea.dao.IUserDao;
import com.xiaokea.domain.User;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2019-09-24 10:51
 */
@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements IUserDao {

    @Resource(name = "sqlSessionFactoryBean")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public User selectById(int id) {
        return getSqlSession().selectOne("user.selectById", id);
    }

    @Override
    public User selectByUser(User user) {
        return getSqlSession().selectOne("user.selectByUser", user);
    }

    @Override
    public User selectByName(String name) {
        return getSqlSession().selectOne("user.selectByName", name);
    }

    public int insert(User user) {
        return getSqlSession().insert("user.insert", user);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteByName(String name) {

    }

    public void deleteOne(int uid) {
        getSqlSession().delete("user.delete", uid);
    }

    public void update(User user) {
        getSqlSession().update("user.update", user);
    }

    public User selectOne(int id) {
        return getSqlSession().selectOne("user.select", id);
    }

    public List<User> selectAll() {
        return getSqlSession().selectList("user.selectAll");
    }

    @Override
    public List<User> selectByMName(String name) {
        return getSqlSession().selectList("user.seleceByMName", name);
    }

    public User loginSelect(User user){
        return getSqlSession().selectOne("user.loginSelect", user);
    }
}