package com.sl.tokenize;

import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;

/**
 * @author shuliangzhao
 * @Title: CreditBillTokenizer
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/6 14:03
 */
public class CreditBillTokenizer extends DelimitedLineTokenizer {
    @Override
    public FieldSet tokenize(String line) {
        return super.tokenize(line);
    }
}
