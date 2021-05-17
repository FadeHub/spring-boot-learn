package com.sl.factory.abstractfatcty.order;

import com.sl.factory.abstractfatcty.pizza.BjCheesePizza;
import com.sl.factory.abstractfatcty.pizza.BjPapperPizza;
import com.sl.factory.abstractfatcty.pizza.Pizza;

/**
 * @author shuliangzhao
 * @Title: BJFactory
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/18 0:08
 */
public class BJFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BjCheesePizza();
        } else if (orderType.equals("papper")) {
            pizza = new BjPapperPizza();
        }
        return pizza;
    }
}
