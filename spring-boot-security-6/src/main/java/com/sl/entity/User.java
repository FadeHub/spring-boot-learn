package com.sl.entity;

import java.io.Serializable;

/**
 * @author shuliangzhao
 * @Title: User
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/3 14:17
 */
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
