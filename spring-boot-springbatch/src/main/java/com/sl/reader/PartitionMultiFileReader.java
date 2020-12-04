package com.sl.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: PartitionMultiFileReader
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/4 21:15
 */
public class PartitionMultiFileReader extends FlatFileItemReader {

    public PartitionMultiFileReader(Class clz,String fileName) {
        setResource(new FileSystemResource(fileName.substring(1)));
        Field[] declaredFields = clz.getDeclaredFields();
        List<String> list = new ArrayList<>();
        for (Field field:declaredFields) {
            list.add(field.getName());
        }
        String[] names = new String[list.size()];
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setDelimiter(",");
        delimitedLineTokenizer.setNames(list.toArray(names));
        DefaultLineMapper defaultLineMapper = new DefaultLineMapper();
        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
        CommonFieldSetMapper commonFieldSetMapper = new CommonFieldSetMapper();
        commonFieldSetMapper.setTargetType(clz);
        defaultLineMapper.setFieldSetMapper(commonFieldSetMapper);
        setLineMapper(defaultLineMapper);
        setName(clz.getSimpleName());
    }

    public static void main(String[] args) {
        String str = "/D:/aplus/bill/bill1.csv";
        System.out.println(str.substring(1));
    }
}
