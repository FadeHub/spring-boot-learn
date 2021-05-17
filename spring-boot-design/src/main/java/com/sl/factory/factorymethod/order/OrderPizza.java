package com.sl.factory.factorymethod.order;


import com.sl.factory.factorymethod.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shuliangzhao
 * @Title: OrderPizza
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/17 23:35
 */
public abstract class OrderPizza {

    public abstract Pizza createPizza(String orderType);

    public OrderPizza() {
        do {
            System.out.println("请输入要订购的pizza:");
            String orderType = getType();
            Pizza pizza = createPizza(orderType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.bake();
            }  else {
                System.out.println(" 未找到订购pizza!");
            }

        } while (true);
    }

    private String getType() {
        BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = strIn.readLine();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
