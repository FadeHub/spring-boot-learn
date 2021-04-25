package com.sl.processor;

import com.sl.common.CommonProcessor;
import com.sl.entity.People;
import com.sl.entity.Student;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author shuliangzhao
 * @Title: PeopleProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/7 17:12
 */
@Component
@StepScope
public class StudentProcessor extends CommonProcessor<People, Student> {

    @Value("#{jobParameters[time]}")
    private Date time;

    @Override
    public void processor(Student o, People people) {
       o.setName(people.getName());
       o.setAddress(people.getAdress());
       o.setAge(people.getAge());
       o.setIdCard(people.getIdCard());
    }
}
