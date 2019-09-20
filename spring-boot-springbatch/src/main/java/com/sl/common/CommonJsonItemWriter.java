package com.sl.common;

import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.batch.item.json.JsonObjectMarshaller;
import org.springframework.core.io.Resource;

/**
 * @author shuliangzhao
 * @Title: CommonJsonItemWriter
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/18 19:54
 */
public class CommonJsonItemWriter<T> extends JsonFileItemWriter<T> {

    public CommonJsonItemWriter(Resource resource, JsonObjectMarshaller<T> jsonObjectMarshaller) {
        super(resource, jsonObjectMarshaller);
        setResource(resource);
        setJsonObjectMarshaller(jsonObjectMarshaller);
        setEncoding("UTF-8");
        setName("tradeJsonFileItemWriter");
    }
}
