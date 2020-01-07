package com.sl.learn.excel;

import java.util.Date;

/**
 * @author shuliangzhao
 * @Title: Stuednt2
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/1/7 20:44
 */
public class Student2 {

    private long id;

    private String name;

    private Date date;

    private int i;

    private Boolean aBoolean;

    public Student2(long l, String s, Date date, int i, boolean b) {
         this.id = l;
         this.name = s;
         this.date = date;
         this.i = i;
         this.aBoolean = b;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }
}
