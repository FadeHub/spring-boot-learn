package com.sl.listener;

import org.springframework.batch.core.SkipListener;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: CatSkipListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/12 19:18
 */
@Component
public class CatSkipListener implements SkipListener {
    @Override
    public void onSkipInRead(Throwable throwable) {
        System.out.println("读的时候发生错误");
    }

    @Override
    public void onSkipInWrite(Object o, Throwable throwable) {
        System.out.println("写的时候发生错误");
    }

    @Override
    public void onSkipInProcess(Object o, Throwable throwable) {
        System.out.println("处理的时候发生错误");
    }
}
