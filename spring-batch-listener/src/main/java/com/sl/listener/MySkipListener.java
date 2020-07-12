package com.sl.listener;

import org.springframework.batch.core.SkipListener;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: MySkipListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/7/12 14:53
 */
@Component
public class MySkipListener implements SkipListener{
    @Override
    public void onSkipInRead(Throwable throwable) {
        System.out.println("skip reader...");
    }

    @Override
    public void onSkipInWrite(Object o, Throwable throwable) {
        System.out.println("skip write...");
    }

    @Override
    public void onSkipInProcess(Object o, Throwable throwable) {
        System.out.println("skip process...");
    }
}
