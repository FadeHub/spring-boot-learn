package com.sl.decorator;

/**
 * 装饰者模式
 * @author shuliangzhao
 * @Title: Drink
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/23 16:23
 */
public abstract class Drink {

    private String des;//描述

    private double price;//价格

    public abstract double cost();

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
