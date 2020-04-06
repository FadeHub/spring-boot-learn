package com.sl.reader;

import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.BufferedReaderFactory;
import org.springframework.batch.item.file.SimpleBinaryBufferedReaderFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;

/**
 * @author shuliangzhao
 * @Title: CustomItemReader
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/3/10 16:38
 */
@Component
@StepScope
public class CustomFileItemReader implements ItemReader<String> {
    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        BufferedReaderFactory bufferedReaderFactory = new SimpleBinaryBufferedReaderFactory();
        FileSystemResource fileSystemResource = new FileSystemResource("D:\\aplus\\shuqian\\target\\"+"CafeCat.csv");
        BufferedReader bufferedReader = bufferedReaderFactory.create(fileSystemResource, "UTF-8");
        if (StringUtils.isNotBlank(bufferedReader.readLine())) {
            return bufferedReader.readLine();
        }
        return null;
    }
}
