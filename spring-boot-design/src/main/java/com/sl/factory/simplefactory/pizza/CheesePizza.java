package com.sl.factory.simplefactory.pizza;

/**
 * @author shuliangzhao
 * @Title: CheesePizza
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/17 23:31
 */
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println(" 给奶酪披萨准备原材料");
    }
}
