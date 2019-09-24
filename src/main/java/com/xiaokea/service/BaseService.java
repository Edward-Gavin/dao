package com.xiaokea.service;


import com.xiaokea.domain.User;

import java.util.List;

public interface BaseService {
    public int insert(User user);

    public void delete(int id);

    public void update(User user);

    public User select(int id);

    public List<User> selectAll();
}

