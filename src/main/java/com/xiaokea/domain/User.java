package com.xiaokea.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @Author: Edward Gavin
 * @Create: 2019-09-24 10:51
 */
@Repository
public class User implements Serializable {
    private int uid;
    private String name;
    private String password;
    private String regtime;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }
}
