package com.sl.future;

import com.sl.util.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * thenCompose 方法允许你对两个 CompletionStage 进行流水线操作，第一个操作完成时，将其结果作为参数传递给第二个操作。
 * @author shuliangzhao
 * @Title: ComFutureCompose
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/25 20:47
 */
public class ComFutureCompose {

    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白进入餐厅");
        SmallTool.printTimeAndThread("小白点了 番茄炒蛋+一碗米饭");

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->{
            SmallTool.printTimeAndThread("厨师炒菜");
            SmallTool.sleepMillis(200);
           return "番茄炒蛋";
        }).thenCompose(dish -> CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("服务员打饭");
            SmallTool.sleepMillis(100);
            return dish + " + 米饭";
        }));

        SmallTool.printTimeAndThread("小白在打王者");
        SmallTool.printTimeAndThread(String.format("%s,小白开吃",future.join()));
    }
}
