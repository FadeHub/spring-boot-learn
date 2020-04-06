package com.sl.processor;

import com.sl.common.CommonProcessor;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: CatProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/10 20:13
 */
@Component
@StepScope
public class CustomCatProcessor implements ItemProcessor<String, Cat> {

    @Override
    public Cat process(String str) throws Exception {
        if (StringUtils.isNotBlank(str)) {
            Cat o = new Cat();
            String[] split = str.split(",");
            o.setCataddress(split[0]);
            o.setCatage(split[1]);
            o.setCatname(split[2]);
            return o;
        }
        return null;
    }
}
