/*
package com.sl.conver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.lang.reflect.Modifier;

*/
/**
 * Gsonjson转换
 * @author shuliangzhao
 * @Title: GsonConfig
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/19 23:43
 *//*

@Configuration
public class GsonConfig {

    @Bean
    GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd");
        builder.excludeFieldsWithModifiers(Modifier.PROTECTED);
        Gson gson = builder.create();
        gsonHttpMessageConverter.setGson(gson);
        return gsonHttpMessageConverter;
    }

}
*/
