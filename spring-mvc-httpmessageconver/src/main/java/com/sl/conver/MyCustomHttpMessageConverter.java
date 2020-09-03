package com.sl.conver;

import org.springframework.http.MediaType;
import org.springframework.http.converter.GenericHttpMessageConverter;

import java.util.Collections;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: MyCustomHttpMessageConverter
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/8/29 18:07
 */
public interface MyCustomHttpMessageConverter extends GenericHttpMessageConverter {

    default List<MediaType> setMediaTypes() {
        return Collections.singletonList(MediaType.ALL);
    }
}
