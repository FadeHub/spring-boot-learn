package com.sl.processor;

import com.sl.common.CommonProcessor;
import com.sl.entity.People;
import com.sl.entity.Student;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

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
    @Override
    public void processor(Student o, People people) {
       o.setName(people.getName());
       o.setAddress(people.getAdress());
       o.setAge(people.getAge());
       o.setIdCar(people.getIdCard());
    }
}
