package com.sl.common;

import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.FileSystemResource;



/**
 * @author shuliangzhao
 * @Title: CommonXmlReader
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/19 19:33
 */
public class CommonXmlReader<T> extends StaxEventItemReader<T> {

    public CommonXmlReader(Class clz) {
        setName("xmlReader");
        setResource(new FileSystemResource("D:\\aplus\\shuqian\\target\\"+clz.getSimpleName()+".xml"));
        setFragmentRootElementName("cat");

    }
}
