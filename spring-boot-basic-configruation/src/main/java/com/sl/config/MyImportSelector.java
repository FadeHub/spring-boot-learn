package com.sl.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @author shuliangzhao
 * @Title: MyImportSelector
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/2/1 18:53
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        return new String[]{"com.sl.entity.Cat"};
    }
}
