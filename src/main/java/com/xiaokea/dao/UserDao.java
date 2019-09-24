package com.xiaokea.dao;

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
public class UserDao extends SqlSessionDaoSupport implements BaseDao{

    @Resource(name = "sqlSessionFactoryBean")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public int insert(User user) {
        return getSqlSession().insert("user.insert", user);
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

    public User loginSelect(User user){
        return getSqlSession().selectOne("com.xiaokea.dao.UserDao.loginSelect", user);
    }
}