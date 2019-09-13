package com.sl.listener;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: CatChunkListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/12 19:08
 */
@Component
public class CatChunkListener implements ChunkListener {
    @Override
    public void beforeChunk(ChunkContext chunkContext) {
        System.out.println("chunk执行之前");
    }

    @Override
    public void afterChunk(ChunkContext chunkContext) {
        System.out.println("chunk执行之后");
    }

    @Override
    public void afterChunkError(ChunkContext chunkContext) {
        System.out.println("chunk执行报错之后");
    }
}
