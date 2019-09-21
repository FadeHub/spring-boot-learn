package com.sl.common;


import org.springframework.batch.item.*;

import java.util.List;

/**
 * 自定义reader
 * @author shuliangzhao
 * @Title: CustomItemReader
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/21 14:49
 */
public class CustomRestaItemReader<T> implements ItemReader<T> , ItemStream {

    private List<T> list;

    int currentIndex = 0;
    private static final String CURRENT_INDEX = "current.index";

    public CustomRestaItemReader(List<T> list) {
        this.list = list;
    }

    @Override
    public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (currentIndex < list.size()) {
            return list.get(currentIndex++);
        }
        return null;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        if(executionContext.containsKey(CURRENT_INDEX)){
            currentIndex = new Long(executionContext.getLong(CURRENT_INDEX)).intValue();
        }
        else{
            currentIndex = 0;
        }
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        executionContext.putLong(CURRENT_INDEX, new Long(currentIndex).longValue());
    }

    @Override
    public void close() throws ItemStreamException {

    }
}
