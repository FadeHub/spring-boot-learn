package com.sl.composite;

import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author shuliangzhao
 * @Title: CatAddressUpperProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/21 10:49
 */
@Component
@StepScope
public class CatAddressUpperProcessor implements ItemProcessor<CafeCat, Cat> {

    @Override
    public Cat process(CafeCat item) throws Exception {
        Cat cat = new Cat();
        cat.setCatname(item.getCatname().toUpperCase(Locale.ROOT));
        cat.setCatage(item.getCatage());
        cat.setCataddress(item.getCataddress().toUpperCase(Locale.ROOT));
        return cat;
    }
}
