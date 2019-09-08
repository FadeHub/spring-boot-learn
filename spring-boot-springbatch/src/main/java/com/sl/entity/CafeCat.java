package com.sl.entity;

/**
 * @author shuliangzhao
 * @Title: CafeCat
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/8 14:36
 */
public class CafeCat {

    private String catname;

    private String catage;

    private String cataddress;


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
