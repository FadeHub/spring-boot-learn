package com.sl.writer;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: CustomItemWriter
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/21 15:03
 */
@Component
@StepScope
public class CustomItemWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> items) throws Exception {
        items.stream().forEach(System.out::println);
    }
}
