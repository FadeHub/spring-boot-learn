package com.sl.factory.abstractfatcty.order;

import com.sl.factory.abstractfatcty.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shuliangzhao
 * @Title: OrderPizza
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/18 0:20
 */
public class OrderPizza {

    public OrderPizza(AbsFactory absFactory) {
        do {
            System.out.println("请输入要订购的pizza：");
            String orderType = getType();
            Pizza pizza = absFactory.createPizza(orderType);
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
