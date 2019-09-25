package com.xiaokea.dao;


import com.xiaokea.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface IUserDao {

    @Insert("insert into user(uid, name, password, regtime) values (#{uid}, #{name}, #{password}, #{regtime})")
    int insert(User user);

    void deleteById(int id);

    void deleteByName(String name);

    void update(User user);

    @Select("select * from user where uid=#{uid}")
    User selectById(int id);

    @Select("select * from user where name=#{name} and password=#{password}")
    User selectByUser(User user);

    @Select("select * from user where name=#{name}")
    User selectByName(String name);

    @Select("select * from user")
    List<User> selectAll();

    @Select("select * from user where name like '%${value}%' ")
    List<User> selectByMName(String name);
}