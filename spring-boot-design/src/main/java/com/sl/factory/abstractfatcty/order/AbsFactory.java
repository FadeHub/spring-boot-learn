package com.sl.factory.abstractfatcty.order;

import com.sl.factory.abstractfatcty.pizza.Pizza;

/**
 * @author shuliangzhao
 * @Title: AbsFactory
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/18 0:06
 */
public interface AbsFactory {

    Pizza createPizza(String orderType);
}
