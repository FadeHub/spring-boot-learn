package com.sl.flyweight;

/**
 * @author shuliangzhao
 * @Title: User
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/27 21:23
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
