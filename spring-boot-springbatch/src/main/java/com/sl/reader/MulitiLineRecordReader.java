package com.sl.reader;

import com.sl.common.CommonUtil;
import com.sl.separator.MulitiLineRecordSeparatorPolicy;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DefaultFieldSetFactory;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

/**
 * @author shuliangzhao
 * @Title: MulitiLineRecordReader
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/6 13:09
 */
public class MulitiLineRecordReader extends FlatFileItemReader {

    public MulitiLineRecordReader(Class clz) {
        setResource(CommonUtil.createResource("D:\\aplus\\muliti\\muliti.csv"));
        String[] names = CommonUtil.names(clz);
        DefaultLineMapper defaultLineMapper = new DefaultLineMapper();
        CommonFieldSetMapper commonFieldSetMapper = new CommonFieldSetMapper();
        commonFieldSetMapper.setTargetType(clz);
        defaultLineMapper.setFieldSetMapper(commonFieldSetMapper);
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setFieldSetFactory(new DefaultFieldSetFactory());
        delimitedLineTokenizer.setNames(names);
        delimitedLineTokenizer.setDelimiter(",");
        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
        MulitiLineRecordSeparatorPolicy mulitiLineRecordSeparatorPolicy = new MulitiLineRecordSeparatorPolicy();
        mulitiLineRecordSeparatorPolicy.setCount(4);
        mulitiLineRecordSeparatorPolicy.setDelimiter(",");
        setRecordSeparatorPolicy(mulitiLineRecordSeparatorPolicy);
        setLineMapper(defaultLineMapper);
    }
}
