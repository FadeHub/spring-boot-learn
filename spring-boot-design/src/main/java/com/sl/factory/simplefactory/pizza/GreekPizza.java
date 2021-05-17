package com.sl.factory.simplefactory.pizza;

/**
 * @author shuliangzhao
 * @Title: GreekPizza
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/17 23:32
 */
public class GreekPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println(" 给希腊披萨准备原材料");
    }
}
