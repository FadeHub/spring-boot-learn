package com.sl.factory.factorymethod.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shuliangzhao
 * @Title: PizzaStore
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/17 23:57
 */
public class PizzaStore {

    public static void main(String[] args) {
       do {
           System.out.println("请输入对应的城市：");
           String local = getLocal();
           if (local.equals("BJ")) {
               new BJOrderPizza();
           } else if (local.equals("LD")) {
               new LDOrderPizza();
           } else {
               System.out.println(" 未找到对应的城市！");
           }
       } while (true);
    }

    private static String getLocal() {
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
