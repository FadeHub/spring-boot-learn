package com.sl.base;

import com.sl.base.handler.ObjectProcessorHandler;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author shuliangzhao
 * @Title: BaseObjectProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/1 21:57
 */
public class BaseObjectProcessor<I,O> implements ItemProcessor<I,O> {

    private ObjectProcessorHandler<I,O> objectProcessorHandler;

    public BaseObjectProcessor(ObjectProcessorHandler<I,O> objectProcessorHandler) {
        this.objectProcessorHandler = objectProcessorHandler;
    }

    @Override
    public O process(I item) throws Exception {
        return objectProcessorHandler.process(item);
    }
}
