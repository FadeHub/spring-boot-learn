package com.sl.common;

import com.sl.common.CommonConstants;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;

import javax.annotation.PostConstruct;
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
 * @date 2019/9/7 16:48
 */
public class CommonFileItemWriter<T> extends FlatFileItemWriter<T> {

    private FileSystemResource fileSystemResource;

    public void init(Class clz) {
        BeanWrapperFieldExtractor beanWrapperFieldExtractor = new BeanWrapperFieldExtractor();
        Field[] fields = clz.getDeclaredFields();
        List<String> list = new ArrayList<>();
        for (java.lang.reflect.Field field : fields) {
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

    public CommonFileItemWriter(Class clz) {
        init(clz);
        fileSystemResource = new FileSystemResource("D:\\aplus\\shuqian\\source\\"+ clz.getSimpleName() + ".csv");
        setResource(fileSystemResource);

    }
}
