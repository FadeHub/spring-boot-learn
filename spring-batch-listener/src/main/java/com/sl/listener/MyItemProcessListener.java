package com.sl.listener;

import org.springframework.batch.core.ItemProcessListener;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: MyItemProcessListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/7/12 14:44
 */
@Component
public class MyItemProcessListener implements ItemProcessListener {
    @Override
    public void beforeProcess(Object o) {
        System.out.println("Process之前...");
    }

    @Override
    public void afterProcess(Object o, Object o2) {
        System.out.println("Process之后...");
    }

    @Override
    public void onProcessError(Object o, Exception e) {
        System.out.println("Process报错...");
    }
}
