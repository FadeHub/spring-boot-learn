package com.sl.service;

import com.sl.anno.MapAnnotationAssembler;
import com.sl.anno.MapField;
import com.sl.anno.MapMapping;

import java.util.Map;

/**
 * @package: com.sl.service
 * @author: shuliangzhao
 * @description:
 * @date 2026/2/9 14:28
 */
@MapMapping
public class User {

    @MapField
    private Long id;

    @MapField
    private String userName;

    @MapField
    private Integer age;

    @MapField(ignore = true)
    private String password;

    public User(Long id, String userName, Integer age, String password) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        User user = new User(1L, "admin", 20, "123456");
        Map<String, Object> userMap = MapAnnotationAssembler.assemble(user);
        System.out.println(userMap);
    }
}
