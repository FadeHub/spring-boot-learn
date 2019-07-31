package com.sl.dto;

/**
 * @author shuliangzhao
 * @Title: Role
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/31 19:44
 */
public class Role {

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
