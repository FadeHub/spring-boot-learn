package com.sl.thread;

import com.sl.config.Constants;

import java.util.concurrent.*;

/**
 * @Classname ThreadPoolFactory
 * @Descriptione 饿汉式加载线程池
 * @Date 2021/9/5 17:01
 * @Created by zhaoshuliang
 */
public class ThreadPoolFactory {


    public static ExecutorService getInstance() {
        return INSTANCE;
    }

    private static final ExecutorService INSTANCE;

    static {
        INSTANCE = new ThreadPoolExecutor(
                Constants.CONCURRENT_FILE_NUMBER, Constants.MAX_CONCURRENT_FILE_NUMBER,
                1000, TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(Constants.MAX_CONCURRENT_FILE_NUMBER << 1),
                callable -> {
                    Thread thread = Executors.defaultThreadFactory().newThread(callable);
                    thread.setDaemon(true);
                    return thread;
                }
                );

    }

}
