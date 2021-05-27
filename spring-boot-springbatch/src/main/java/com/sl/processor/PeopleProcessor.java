package com.sl.processor;

import com.sl.entity.People;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author shuliangzhao
 * @Title: PeopleProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/28 17:04
 */
@Component
@StepScope
public class PeopleProcessor implements ItemProcessor<People,People> {
    @Override
    public People process(People item) throws Exception {
        if (Integer.parseInt(item.getAge()) < 10) {
          return null;
        }
        People people = new People();
        people.setName(item.getName().toLowerCase(Locale.ROOT));
        people.setIdCard(item.getIdCard());
        people.setAge(item.getAge());
        people.setAdress(item.getAdress().toUpperCase(Locale.ROOT));
        return people;
    }
}
