package com.xiaokea.service;

import com.xiaokea.domain.User;

public interface UserService extends BaseService{
    public User loginCheck(User user);
}
