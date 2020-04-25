package com.sl.learn.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author shuliangzhao
 * @Title: MyCallable
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/4/12 17:19
 */
public class MyCallable implements Callable<Integer> {
    private int i = 0;
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建MyCallable对象
        Callable<Integer> myCallable = new MyCallable();
        //使用FutureTask来包装MyCallable对象
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable);
        for (int i = 0;i<50;i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            if (i == 30) {
                Thread thread = new Thread(ft);
                thread.start();
            }
        }
        System.out.println("主线程for循环执行完毕..");
        Integer integer = ft.get();
        System.out.println("sum = "+ integer);
    }
}
