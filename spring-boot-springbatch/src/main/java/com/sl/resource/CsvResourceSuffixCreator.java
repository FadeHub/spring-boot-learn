package com.sl.resource;

import org.springframework.batch.item.file.ResourceSuffixCreator;

/**
 * @author shuliangzhao
 * @Title: CsvResourceSuffixCreator
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/8 13:20
 */
public class CsvResourceSuffixCreator implements ResourceSuffixCreator {
    @Override
    public String getSuffix(int i) {
        return i + ".csv" ;
    }
}
