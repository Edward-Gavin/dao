package com.xiaokea.service.Impl;


import com.xiaokea.dao.Impl.UserDaoImpl;
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

    @Resource(name = "userDaoImpl")
    private UserDaoImpl userDaoImpl;

    public int insert(User user) {
        return userDaoImpl.insert(user);
    }

    public void delete(int id) {
        userDaoImpl.deleteOne(id);
    }

    public void update(User user) {
        userDaoImpl.update(user);
    }

    public User select(int id) {
        return userDaoImpl.selectOne(id);
    }

    public List<User> selectAll() {
        return userDaoImpl.selectAll();
    }

    public User loginCheck(User user) {
        return userDaoImpl.loginSelect(user);
    }
}