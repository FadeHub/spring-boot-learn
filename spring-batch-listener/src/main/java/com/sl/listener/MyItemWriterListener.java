package com.sl.listener;

import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: MyItemWriterListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/7/12 14:49
 */
@Component
public class MyItemWriterListener implements ItemWriteListener {
    @Override
    public void beforeWrite(List list) {
        System.out.println("writer之前...");
    }

    @Override
    public void afterWrite(List list) {
        System.out.println("writer之后...");
    }

    @Override
    public void onWriteError(Exception e, List list) {
        System.out.println("writer异常...");
    }
}
