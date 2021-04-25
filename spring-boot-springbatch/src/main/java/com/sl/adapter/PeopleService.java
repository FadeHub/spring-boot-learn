package com.sl.adapter;

import com.sl.entity.People;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * @author shuliangzhao
 * @Title: StudentService
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/25 20:12
 */
@Service
public class PeopleService {

    public People upperCase(People people) {
         People p = new People();
         p.setName(people.getName().toUpperCase(Locale.ROOT));
         p.setAdress(people.getAdress().toUpperCase(Locale.ROOT));
         p.setAge(people.getAge());
         p.setIdCard(people.getIdCard());
         return p;
    }
}
