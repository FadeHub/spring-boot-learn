package com.sl.entity;

/**
 * @author shuliangzhao
 * @Title: Cat
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/8 14:29
 */
public class Cat {

    private Integer id;

    private String catname;

    private String catage;

    private String cataddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getCatage() {
        return catage;
    }

    public void setCatage(String catage) {
        this.catage = catage;
    }

    public String getCataddress() {
        return cataddress;
    }

    public void setCataddress(String cataddress) {
        this.cataddress = cataddress;
    }
}
