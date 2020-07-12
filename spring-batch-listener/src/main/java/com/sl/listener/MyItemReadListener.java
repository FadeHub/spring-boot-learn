package com.sl.listener;

import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: MyItemReadListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/7/12 14:41
 */
@Component
public class MyItemReadListener implements ItemReadListener {
    @Override
    public void beforeRead() {
        System.out.println("reder之前...");
    }

    @Override
    public void afterRead(Object o) {
        System.out.println("reder之后...");
    }

    @Override
    public void onReadError(Exception e) {
        System.out.println("reder报错...");
    }
}
