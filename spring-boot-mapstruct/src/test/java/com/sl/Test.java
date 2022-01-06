package com.sl;

import com.sl.conver.PersonConver;
import com.sl.dto.PersonDto;
import com.sl.entity.Person;

/**
 * @package: com.sl
 * @author: shuliangzhao
 * @description:
 * @date 2022/1/6 21:53
 */
public class Test {

    @org.junit.Test
    public void test() {
        Person person = new Person();
        person.setUsername("张三");
        person.setAge(20);
        person.setEmail("20003@qq.com");
        person.setIdCard("2333");
        person.setAddress("北京市丰台区");
        PersonDto personDto = PersonConver.INSTANCE.converDto(person);
        System.out.println(personDto);
    }

}
