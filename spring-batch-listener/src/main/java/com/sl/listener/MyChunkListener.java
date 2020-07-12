package com.sl.listener;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: MyChunkListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/7/12 14:35
 */
@Component
public class MyChunkListener implements ChunkListener {
    @Override
    public void beforeChunk(ChunkContext chunkContext) {
        System.out.println("chunk执行之前：" +System.currentTimeMillis());
    }

    @Override
    public void afterChunk(ChunkContext chunkContext) {
        System.out.println("chunk执行之后：" +System.currentTimeMillis());
    }

    @Override
    public void afterChunkError(ChunkContext chunkContext) {
        System.out.println("chunk执行出错...");
    }
}
