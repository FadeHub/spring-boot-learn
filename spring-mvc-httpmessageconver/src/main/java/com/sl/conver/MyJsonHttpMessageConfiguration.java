package com.sl.conver;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: MyJsonHttpMessageConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/8/29 19:40
 */
@Configuration
public class MyJsonHttpMessageConfiguration {

    @Bean
    @ConditionalOnMissingBean(FastJsonHttpMessageConverter.class)
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        //1.需要定义一个convert转换消息的对象
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //2.添加fastJson的配置信息;
        FastJsonConfig config = new FastJsonConfig();
        //添加配置-config.setSerializerFeatures()  方法中可以添加多个配置（以，分开）
        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue,SerializerFeature.DisableCircularReferenceDetect);
        //添加配置-config.setSerializerFeatures()  方法中可以添加多个配置（以，分开）
        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue,SerializerFeature.DisableCircularReferenceDetect);
        fastJsonHttpMessageConverter.setFastJsonConfig(config);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(getSupportedMediaTypes());
        fastJsonHttpMessageConverter.setDefaultCharset(Charset.forName("UTF-8"));
        return fastJsonHttpMessageConverter;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("amed_cust_no","amed_nbr","amed_post_acct_no","amed_action");
        for (String str:list) {
            String[] split = str.split("\\_");
            String s1  = "";
            for (int i = 0;i<split.length;i++) {
                if (i==0) {
                    s1 = split[0];
                }else {
                    s1 = s1 + (split[i].substring(0,1).toUpperCase() + split[i].substring(1));
                }
            }
            System.out.println(s1);
        }
    }

    /**
     *  配置全局支持的媒体类型
     */
    private List<MediaType> getSupportedMediaTypes() {
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);
        return supportedMediaTypes;
    }
}
