package com.sl.listener;

import com.sl.generic.ChannelProcessor;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author shuliangzhao
 * @Title: MyChunkListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/7/12 14:35
 */
@Component
public class MyChunkListener implements ChunkListener {

    @Autowired
    private Map<String, ChannelProcessor> channelProcessorMap;

    private ChannelProcessor channelProcessor;

    @Override
    public void beforeChunk(ChunkContext chunkContext) {
        channelProcessor = channelProcessorMap.get("jcbChannelProcessor");
        channelProcessor.processor();
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
