package com.sl.factory.abstractfatcty.pizza;

/**
 * @author shuliangzhao
 * @Title: Pizza
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/17 23:27
 */
public abstract class Pizza {

    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public abstract void prepare();

    public void bake() {
        System.out.println(name + " bake;");
    }

    public void cut() {
        System.out.println(name + " cut;");
    }

    public void box() {
        System.out.println(name + " box;");
    }
}
