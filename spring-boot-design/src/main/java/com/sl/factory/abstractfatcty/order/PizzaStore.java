package com.sl.factory.abstractfatcty.order;

/**
 * @author shuliangzhao
 * @Title: PizzaStore
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/18 0:23
 */
public class PizzaStore {

    public static void main(String[] args) {
        new OrderPizza(new BJFactory());
    }
}
