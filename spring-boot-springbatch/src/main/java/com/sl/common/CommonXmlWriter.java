package com.sl.common;

import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.Marshaller;

/**
 * 公共写xml文件
 * @author shuliangzhao
 * @Title: CommonXmlWriter
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/20 18:46
 */
public class CommonXmlWriter<T> extends StaxEventItemWriter<T> {


    public CommonXmlWriter(Marshaller marshaller,Class clz) {
        setName("commonXmlWriter");
        setMarshaller(marshaller);
        setResource(new FileSystemResource("D:\\aplus\\shuqian\\source\\"+ clz.getSimpleName() + ".xml"));
        setRootTagName("cat");
        setOverwriteOutput(true);
    }
}
