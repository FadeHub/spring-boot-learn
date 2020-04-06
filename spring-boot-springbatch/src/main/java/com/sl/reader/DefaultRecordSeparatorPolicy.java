package com.sl.reader;

import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.file.separator.RecordSeparatorPolicy;

/**
 * @author shuliangzhao
 * @Title: DefaultRecordSeparatorPolicy
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/3/10 15:59
 */
public class DefaultRecordSeparatorPolicy implements RecordSeparatorPolicy {
    @Override
    public boolean isEndOfRecord(String record) {
        return false;
    }

    @Override
    public String postProcess(String record) {
        if (StringUtils.isBlank(record)) {
            record = "jim,1,Customer1";
            return record;
        }
        System.out.println(record);
        return record;
    }

    @Override
    public String preProcess(String record) {
        if (StringUtils.isBlank(record)) {
            record = "jim,1,Customer1";
            return record;
        }
        System.out.println(record);
        return record;
    }
}
