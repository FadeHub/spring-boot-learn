package com.sl.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.Iterator;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: MyItemReader
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/7/12 15:19
 */
public class MyItemReader implements ItemReader<String> {
    private Iterator<String> iterator;

    public MyItemReader(List<String> data) {
        this.iterator = data.iterator();
    }

    @Override
    public String read() {
        return iterator.hasNext() ? iterator.next() : null;
    }
}