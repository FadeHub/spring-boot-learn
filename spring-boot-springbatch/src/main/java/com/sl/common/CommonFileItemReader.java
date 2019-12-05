package com.sl.common;

import com.sl.common.CommonConstants;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineCallbackHandler;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DefaultFieldSetFactory;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * 公共读方法
 * @author shuliangzhao
 * @Title: CommonItemReader
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/7 16:30
 */
public class CommonFileItemReader<T> extends FlatFileItemReader<T> {

     private FileSystemResource fileSystemResource;

     public CommonFileItemReader(Class clz) {
         setEncoding(CommonConstants.ENCODING_READ);
         fileSystemResource = new FileSystemResource("D:\\aplus\\shuqian\\target\\"+clz.getSimpleName()+".csv");
         setResource(fileSystemResource);
         DefaultLineMapper defaultLineMapper = new DefaultLineMapper();
         DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
         delimitedLineTokenizer.setFieldSetFactory(new DefaultFieldSetFactory());
         Field[] fields = clz.getDeclaredFields();
         List<String> list = new ArrayList<>();
         for (Field field : fields) {
             if (!Modifier.isStatic(field.getModifiers())) {
                  list.add(field.getName());
             }
         }
         String[] names = new String[list.size()];
         delimitedLineTokenizer.setNames(list.toArray(names));
         delimitedLineTokenizer.setDelimiter(",");
         defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
         BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper();
         fieldSetMapper.setTargetType(clz);
         defaultLineMapper.setFieldSetMapper(fieldSetMapper);
         setLineMapper(defaultLineMapper);
         setLinesToSkip(1);
         setSkippedLinesCallback(new LineCallbackHandler() {
             @Override
             public void handleLine(String line) {
                 String[] split = line.split(",");
                 System.out.println(split);
             }
         });
     }
}
