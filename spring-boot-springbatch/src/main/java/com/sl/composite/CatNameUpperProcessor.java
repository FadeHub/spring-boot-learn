package com.sl.composite;

import com.sl.entity.CafeCat;
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
public class CatNameUpperProcessor implements ItemProcessor<Cat, CafeCat> {

    @Override
    public CafeCat process(Cat item) throws Exception {
        CafeCat cafeCat = new CafeCat();
        cafeCat.setCatname(item.getCatname().toUpperCase());
        cafeCat.setCatage(item.getCatage());
        cafeCat.setCataddress(item.getCataddress());
        return cafeCat;
    }
}
