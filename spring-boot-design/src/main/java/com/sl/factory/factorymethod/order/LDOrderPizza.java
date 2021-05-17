package com.sl.factory.factorymethod.order;

import com.sl.factory.factorymethod.pizza.LDCheesePizza;
import com.sl.factory.factorymethod.pizza.LDPapperPizza;
import com.sl.factory.factorymethod.pizza.Pizza;

/**
 * @author shuliangzhao
 * @Title: LDOrderPizza
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/17 23:56
 */
public class LDOrderPizza extends OrderPizza{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
            pizza.setName("cheese");
        } else if (orderType.equals("papper")) {
            pizza = new LDPapperPizza();
            pizza.setName("papper");
        }
        return pizza;
    }
}
