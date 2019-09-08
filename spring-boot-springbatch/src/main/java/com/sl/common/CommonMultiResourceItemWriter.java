package com.sl.common;

import com.sl.resource.CsvResourceSuffixCreator;
import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * @author shuliangzhao
 * @Title: CommonMultiResourceItemWriter
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/8 13:05
 */
public class CommonMultiResourceItemWriter<T> extends MultiResourceItemWriter<T> {

    public CommonMultiResourceItemWriter(Class clz) {
        setDelegate(new CommonFileItemWriter<>(clz));
        setResource(getResource(clz));
        setResourceSuffixCreator(new CsvResourceSuffixCreator());
    }

    private Resource getResource(Class clz) {
       FileSystemResource fileSystemResource = new FileSystemResource("D:\\aplus\\shuqian\\source\\" +clz.getSimpleName());
        return fileSystemResource;
    }

}
