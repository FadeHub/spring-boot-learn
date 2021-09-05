package com.sl.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Classname TimeUtil
 * @Description 程序耗时
 * @Date 2021/9/5 17:23
 * @Created by zhaoshuliang
 */
public class TimeUtil {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public interface Task {
        void execute();
    }

    public static void times(String title,Task task) {
        if (task == null) return;
        title = (title == null) ? "" : ("【" + title + "】");
        System.out.println(title);
        System.out.println("开始：" + formatter.format(LocalTime.now()));
        long begin = System.currentTimeMillis();
        task.execute();
        long end = System.currentTimeMillis();
        System.out.println("结束：" + formatter.format(LocalTime.now()));
        double delta = (end - begin) / 1000.0;
        System.out.println("耗时：" + delta + "秒");
        System.out.println("-------------------------------------");
    }

}
