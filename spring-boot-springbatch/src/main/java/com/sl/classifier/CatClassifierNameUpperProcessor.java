package com.sl.classifier;

import com.sl.entity.Cat;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


/**
 * @author shuliangzhao
 * @Title: CatNameUpperProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/21 10:38
 */
@Component
@StepScope
public class CatClassifierNameUpperProcessor implements ItemProcessor<Cat, Cat> {

    @Override
    public Cat process(Cat item) throws Exception {
        Cat cat = new Cat();
        cat.setCatname(item.getCatname().toUpperCase());
        cat.setCatage(item.getCatage());
        cat.setCataddress(item.getCataddress());
        return cat;
    }
}
