package com.sl.base.handler;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: ObjectWriterDbWriter
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/1 22:07
 */
public class ObjectWriterDbWriter<T> implements ItemWriter<T> {

    private WriterObjectToDbHander hander;

    public ObjectWriterDbWriter(WriterObjectToDbHander hander) {
        this.hander = hander;
    }

    @Override
    public void write(List<? extends T> items) throws Exception {
        hander.write(items);
    }
}
