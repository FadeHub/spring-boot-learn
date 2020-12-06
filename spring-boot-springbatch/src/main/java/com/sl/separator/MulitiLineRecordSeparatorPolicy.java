package com.sl.separator;

import org.springframework.batch.item.file.separator.RecordSeparatorPolicy;

/**
 * @author shuliangzhao
 * @Title: MulitLineRecordSeparatorPolicy
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/6 13:05
 */
public class MulitiLineRecordSeparatorPolicy implements RecordSeparatorPolicy {

    private String delimiter = ",";

    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public boolean isEndOfRecord(String record) {
        return countDelimiter(record) == count;
    }

    private int countDelimiter(String record) {
        String temp = record;
        int index = -1;
        int count = 0;
        while ((index=temp.indexOf(",")) != -1) {
            temp = temp.substring(index +1);
            count++;
        }
        return count;
    }

    @Override
    public String postProcess(String record) {
        return record;
    }

    @Override
    public String preProcess(String record) {
        return record;
    }
}
