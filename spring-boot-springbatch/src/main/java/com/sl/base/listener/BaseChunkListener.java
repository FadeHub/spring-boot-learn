package com.sl.base.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

/**
 * @author shuliangzhao
 * @Title: BaseChunkListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/1 19:55
 */
public class BaseChunkListener implements ChunkListener,BaseRpwListener {

    private static final Logger logger = LoggerFactory.getLogger(BaseChunkListener.class);

    @Override
    public void beforeChunk(ChunkContext context) {
        
    }

    @Override
    public void afterChunk(ChunkContext context) {

    }

    @Override
    public void afterChunkError(ChunkContext context) {
         handler(logger,(Exception) context.getAttribute(ChunkListener.ROLLBACK_EXCEPTION_KEY));
    }
}
