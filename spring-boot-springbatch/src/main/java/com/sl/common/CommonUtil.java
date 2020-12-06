package com.sl.common;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: CommonUtil
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/6 13:11
 */
public class CommonUtil {

    public static Resource createResource(String filePath) {
      return new FileSystemResource(filePath);
    }

    public static String[] names(Class clz) {
        Field[] fields = clz.getDeclaredFields();
        List<String> list = new ArrayList<>();
        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                list.add(field.getName());
            }
        }
        String[] names = new String[list.size()];
        return list.toArray(names);
    }
}
