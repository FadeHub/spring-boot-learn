package com.sl.common;


import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.List;

/**
 * 自定义reader
 * @author shuliangzhao
 * @Title: CustomItemReader
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/21 14:49
 */
public class CustomItemReader<T> implements ItemReader<T> {

    private List<String> list;

    public CustomItemReader(List<String> list) {
        this.list = list;
    }

    @Override
    public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (list.size() > 0 && !list.isEmpty()) {
            return (T)list.remove(0);
        }
        return null;
    }
}
