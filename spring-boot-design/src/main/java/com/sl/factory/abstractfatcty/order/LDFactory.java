package com.sl.factory.abstractfatcty.order;

import com.sl.factory.abstractfatcty.pizza.*;

/**
 * @author shuliangzhao
 * @Title: LDFactory
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/18 0:08
 */
public class LDFactory implements AbsFactory {

    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("papper")) {
            pizza = new LDPapperPizza();
        }
        return pizza;    }
}
