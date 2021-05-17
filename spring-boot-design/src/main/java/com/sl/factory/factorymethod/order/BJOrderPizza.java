package com.sl.factory.factorymethod.order;

import com.sl.factory.factorymethod.pizza.BjCheesePizza;
import com.sl.factory.factorymethod.pizza.BjPapperPizza;
import com.sl.factory.factorymethod.pizza.Pizza;

/**
 * @author shuliangzhao
 * @Title: BJOrderPizza
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/17 23:54
 */
public class BJOrderPizza extends OrderPizza{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BjCheesePizza();
            pizza.setName("cheese");
        } else if (orderType.equals("papper")) {
            pizza = new BjPapperPizza();
            pizza.setName("papper");
        }
        return pizza;
    }
}
