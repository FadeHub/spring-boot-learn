package com.sl.common;

import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 顺序读取多个文件
 * @author shuliangzhao
 * @Title: CommonMultiResourceItemReader
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/8 12:34
 */
public class CommonMultiResourceItemReader<T>  extends MultiResourceItemReader<T> {

    public CommonMultiResourceItemReader(Class clz) {
        setResources(getResource());
        setDelegate(new CommonFileItemReader<>(clz));
    }

    private Resource[] getResource() {
        List<Resource> resourceList = new ArrayList<>();
        String filePath = "D:\\aplus\\shuqian\\target";
        File file = new File(filePath);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str : list) {
                    String resource = file.getPath() + "\\" + str;
                    FileSystemResource fileSystemResource = new FileSystemResource(resource);
                    resourceList.add(fileSystemResource);
                }
            }
        }
        Resource[] resources = new Resource[resourceList.size()];
        return resourceList.toArray(resources);
    }
}
