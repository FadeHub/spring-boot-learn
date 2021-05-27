package com.sl.processor;

import com.sl.entity.People;
import com.sl.entity.Student;
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
public class StudentDbProcessor implements ItemProcessor<People, Student> {
    @Override
    public Student process(People item) throws Exception {
        if (Integer.parseInt(item.getAge()) < 10) {
          return null;
        }
        Student student = new Student();
        student.setName(item.getName().toLowerCase(Locale.ROOT));
        student.setIdCard(item.getIdCard());
        student.setAge(item.getAge());
        student.setAddress(item.getAdress().toLowerCase(Locale.ROOT));
        return student;
    }
}
