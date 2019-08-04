package com.sl.entity;

import java.io.Serializable;

/**
 * @author shuliangzhao
 * @Title: UserRole
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/3 14:25
 */
public class UserRole implements Serializable {

    private Integer id;

    private Integer uid;

    private Integer rid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
