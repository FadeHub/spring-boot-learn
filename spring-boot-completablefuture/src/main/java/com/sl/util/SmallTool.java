package com.sl.util;

import java.util.StringJoiner;

/**
 * @author shuliangzhao
 * @Title: SmallTool
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/25 20:38
 */
public class SmallTool {

    public static void sleepMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printTimeAndThread(String tag) {
        String result = new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(tag)
                .toString();
        System.out.println(result);
    }
}
