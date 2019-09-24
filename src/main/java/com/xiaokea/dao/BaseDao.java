package com.xiaokea.dao;


import com.xiaokea.domain.User;

import java.util.List;


public interface BaseDao {
    int insert(User user);

    void deleteOne(int id);

    void update(User user);

    User selectOne(int id);

    List<User> selectAll();
}