package com.sl.dao;

import com.sl.aspect.Log;
import com.sl.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: UserDao
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/23 22:11
 */
@Repository
public class UserDao {

    @Resource(name = "jdbcTemplateOne")
    private JdbcTemplate jdbcTemplateOne;

    @Resource(name = "jdbcTemplateTwo")
    private JdbcTemplate jdbcTemplateTwo;
    @Log
    public void save(User user) {
        //jdbcTemplateOne.update("insert into user (name,age) values (?,?)",user.getName(),user.getAge());
        jdbcTemplateTwo.update("insert into user (name,age) values (?,?)",user.getName(),user.getAge());
    }

    public void getList() {
        List<User> user1 = jdbcTemplateOne.query("select * from user",new BeanPropertyRowMapper<>(User.class));
        List<User> user2 = jdbcTemplateTwo.query("select * from user",new BeanPropertyRowMapper<>(User.class));
        System.out.println("user1:" + user1);
        System.out.println("user2:" + user2);
    }
}
