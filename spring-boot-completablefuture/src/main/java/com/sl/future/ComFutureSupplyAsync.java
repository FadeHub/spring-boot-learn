package com.sl.future;

import com.sl.thread.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * supplyAsync
 * @author shuliangzhao
 * @Title: ComFuture
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/25 20:39
 */
public class ComFutureSupplyAsync {

    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白进入餐厅");
        SmallTool.printTimeAndThread("小白点了 番茄炒蛋+一碗米饭");

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->{
            SmallTool.printTimeAndThread("厨师炒菜");
            SmallTool.sleepMillis(200);
            SmallTool.printTimeAndThread("厨师打饭");
            SmallTool.sleepMillis(100);
            return "番茄炒蛋 + 米饭 做好了";
        });

        SmallTool.printTimeAndThread("小白在打王者");
        SmallTool.printTimeAndThread(String.format("%s,小白开吃",future.join()));
    }
}
