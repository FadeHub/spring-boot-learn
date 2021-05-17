package com.sl.factory.simplefactory.order;

import com.sl.factory.simplefactory.pizza.CheesePizza;
import com.sl.factory.simplefactory.pizza.GreekPizza;
import com.sl.factory.simplefactory.pizza.Pizza;

/**
 * @author shuliangzhao
 * @Title: SimpleFactoryPizza
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/17 23:35
 */
public class SimpleFactoryPizza {

    public static Pizza createPizza(String orderType) {
          Pizza pizza = null;
          if (orderType.equals("greek")) {
              pizza = new GreekPizza();
              pizza.setName("greek");
          }else if (orderType.equals("cheese")){
              pizza = new CheesePizza();
              pizza.setName("cheese");
          }
          return pizza;
    }
}
