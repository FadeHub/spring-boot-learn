package com.sl.future;

import com.sl.thread.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * 当一个线程依赖另一个线程时，可以使用 thenApply 方法来把这两个线程串行化。
 * @author shuliangzhao
 * @Title: ComfutureApply
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/25 21:24
 */
public class ComfutureApply {

    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白吃好了");
        SmallTool.printTimeAndThread("小白 结账、要求开发票");

        CompletableFuture<String> invoice = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("服务员收款 500元");
            SmallTool.sleepMillis(100);
            return "500";
        }).thenApplyAsync(money -> {
            SmallTool.printTimeAndThread(String.format("服务员开发票 面额 %s元", money));
            SmallTool.sleepMillis(200);
            return String.format("%s元发票", money);
        });

        SmallTool.printTimeAndThread("小白 接到朋友的电话，想一起打游戏");

        SmallTool.printTimeAndThread(String.format("小白拿到%s，准备回家", invoice.join()));
    }
}
