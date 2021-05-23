package com.sl.decorator;

/**
 * @author shuliangzhao
 * @Title: Coffee
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/23 16:24
 */
public class Coffee extends Drink{
    @Override
    public double cost() {
        return super.getPrice();
    }
}
