package com.sl.decorator;

/**
 * @author shuliangzhao
 * @Title: Decorator
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/23 16:28
 */
public class Decorator extends Drink{

    private Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public double cost() {
        return super.getPrice() + obj.getPrice();
    }

    @Override
    public String getDes() {
        return super.getDes() + " " +getPrice() + "&&" + obj.getDes();
    }
}
