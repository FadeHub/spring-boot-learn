package com.sl.conver;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: MyJsonHttpMessageConverter
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/8/29 17:18
 */
public class MyJsonHttpMessageConverter implements HttpMessageConverter {
    //Jackson 的 Json 映射类
    private ObjectMapper mapper = new ObjectMapper ();

    // 该转换器的支持类型：application/json
    private List supportedMediaTypes = Arrays.asList (MediaType.APPLICATION_JSON);

    /**
     * 判断转换器是否可以将输入内容转换成 Java 类型
     * @param clazz 需要转换的 Java 类型
     * @param mediaType 该请求的 MediaType
     * @return
     */
    @Override
    public boolean canRead (Class clazz, MediaType mediaType) {
        if (mediaType == null) {
            return true;
        }
        for (MediaType supportedMediaType : getSupportedMediaTypes ()) {
            if (supportedMediaType.includes (mediaType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断转换器是否可以将 Java 类型转换成指定输出内容
     * @param clazz 需要转换的 Java 类型
     * @param mediaType 该请求的 MediaType
     * @return
     */
    @Override
    public boolean canWrite (Class clazz, MediaType mediaType) {
        if (mediaType == null || MediaType.ALL.equals (mediaType)) {
            return true;
        }
        for (MediaType supportedMediaType : getSupportedMediaTypes ()) {
            if (supportedMediaType.includes (mediaType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获得该转换器支持的 MediaType
     * @return
     */
    @Override
    public List<MediaType>  getSupportedMediaTypes () {
        return supportedMediaTypes;
    }

    /**
     * 读取请求内容，将其中的 Json 转换成 Java 对象
     * @param clazz 需要转换的 Java 类型
     * @param inputMessage 请求对象
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    public Object read (Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return mapper.readValue (inputMessage.getBody (), clazz);
    }

    /**
     * 将 Java 对象转换成 Json 返回内容
     * @param o 需要转换的对象
     * @param contentType 返回类型
     * @param outputMessage 回执对象
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    public void write (Object o, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        mapper.writeValue (outputMessage.getBody (), o);
    }
}
