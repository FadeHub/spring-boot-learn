package com.sl.common;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * 公共写
 * @author shuliangzhao
 * @Title: CommonFileItemWriter
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/15 20:48
 */
public class CommonPartitionFileItemWriter<T> extends FlatFileItemWriter<T> {

    private FileSystemResource fileSystemResource;

    public void init(Class clz) {
        BeanWrapperFieldExtractor beanWrapperFieldExtractor = new BeanWrapperFieldExtractor();
        Field[] fields = clz.getDeclaredFields();
        List<String> list = new ArrayList<>();
        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                list.add(field.getName());
            }
        }
        String[] names = new String[list.size()];
        beanWrapperFieldExtractor.setNames(list.toArray(names));
        beanWrapperFieldExtractor.afterPropertiesSet();
        DelimitedLineAggregator lineAggregator = new DelimitedLineAggregator();
        lineAggregator.setDelimiter(",");
        lineAggregator.setFieldExtractor(beanWrapperFieldExtractor);
        setLineAggregator(lineAggregator);
        setName(clz.getSimpleName());
        setEncoding(CommonConstants.ENCODING_READ);
    }

    public CommonPartitionFileItemWriter(Class clz,String fromId,String toId) {
        init(clz);
        fileSystemResource = new FileSystemResource("D:\\aplus\\shuqian\\source\\"+ clz.getSimpleName()+"-"+fromId + "-" + toId  + ".csv");
        setResource(fileSystemResource);

    }
}
