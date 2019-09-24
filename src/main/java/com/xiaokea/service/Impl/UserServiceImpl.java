package com.xiaokea.service.Impl;


import com.xiaokea.dao.UserDao;
import com.xiaokea.domain.User;
import com.xiaokea.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2019-09-24 11:45
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    public int insert(User user) {
        return userDao.insert(user);
    }

    public void delete(int id) {
        userDao.deleteOne(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public User select(int id) {
        return userDao.selectOne(id);
    }

    public List<User> selectAll() {
        return userDao.selectAll();
    }

    public User loginCheck(User user) {
        return userDao.loginSelect(user);
    }
}