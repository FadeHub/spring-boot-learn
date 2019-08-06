package com.sl.entity;

import java.io.Serializable;

/**
 * @author shuliangzhao
 * @Title: Role
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/3 14:18
 */
public class Role implements Serializable {

    private Integer id;

    private String name;

    private String nameZh;

    public Integer getId() {    
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
}
