package com.sl.common;

import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.JsonObjectReader;
import org.springframework.core.io.Resource;

/**
 * @author shuliangzhao
 * @Title: CommonJsonItemReader
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/17 20:00
 */
public class CommonJsonItemReader<T> extends JsonItemReader<T> {

    public CommonJsonItemReader(Resource resource, JsonObjectReader<T> jsonObjectReader) {
        super(resource, jsonObjectReader);
        setJsonObjectReader(jsonObjectReader);
        setName("tradeJsonItemReader");
        setResource(resource);
    }
}
