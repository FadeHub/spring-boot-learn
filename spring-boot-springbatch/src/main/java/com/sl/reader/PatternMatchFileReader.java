package com.sl.reader;

import com.sl.common.CommonUtil;
import com.sl.fieldsetmpper.CreditBillFieldSetMapper;
import com.sl.fieldsetmpper.DebitBillFieldSetMapper;
import com.sl.tokenize.CreditBillTokenizer;
import com.sl.tokenize.DebitBillTokenizer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.LineTokenizer;

import java.util.HashMap;
import java.util.Map;

/**
 * 读取混合文件reader
 * @author shuliangzhao
 * @Title: PatternMatchFileReader
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/6 13:55
 */
public class PatternMatchFileReader extends FlatFileItemReader {

    public PatternMatchFileReader(Class clz,Class clz1) {
       setResource(CommonUtil.createResource("D:\\aplus\\muliti\\pattern.csv"));
        PatternMatchingCompositeLineMapper patternMatchingCompositeLineMapper = new PatternMatchingCompositeLineMapper();
        Map<String, LineTokenizer> map = new HashMap<>();
        createTokenizer(map,clz,clz1);
        patternMatchingCompositeLineMapper.setTokenizers(map);
        Map<String, FieldSetMapper> map1 = new HashMap<>();
        createFieldSetMapper(map1,clz,clz1);
        patternMatchingCompositeLineMapper.setFieldSetMappers(map1);
        setLineMapper(patternMatchingCompositeLineMapper);
    }

    private void createFieldSetMapper(Map<String, FieldSetMapper> map1,Class clz,Class clz1) {
        DebitBillFieldSetMapper debitBillFieldSetMapper = new DebitBillFieldSetMapper();
        CreditBillFieldSetMapper creditBillFieldSetMapper = new CreditBillFieldSetMapper();
        map1.put("4*",creditBillFieldSetMapper);
        map1.put("3*",debitBillFieldSetMapper);
    }

    private void createTokenizer(Map<String, LineTokenizer> map,Class clz,Class clz1) {
        CreditBillTokenizer creditBillTokenizer = new CreditBillTokenizer();
        creditBillTokenizer.setNames(CommonUtil.names(clz));
        creditBillTokenizer.setDelimiter(",");
        DebitBillTokenizer debitBillTokenizer = new DebitBillTokenizer();
        debitBillTokenizer.setNames(CommonUtil.names(clz1));
        debitBillTokenizer.setDelimiter(",");
        map.put("4*",creditBillTokenizer);
        map.put("3*",debitBillTokenizer);
    }
}
