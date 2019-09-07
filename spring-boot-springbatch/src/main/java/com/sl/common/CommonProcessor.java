package com.sl.common;

import org.springframework.batch.item.ItemProcessor;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;

/**
 * 公共处理
 * @author shuliangzhao
 * @Title: CommonProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/7 16:39
 */
public abstract class CommonProcessor<I,O> implements ItemProcessor<I,O> {

    private Class<I> input;

    private Class<O> output;

    @PostConstruct
    public void init() {
        input = (Class<I>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        output = (Class<O>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Override
    public O process(I i) throws Exception {
        O o = output.newInstance();
        processor(o,i);
        return o;
    }

    public abstract void processor(O o, I i);
}
