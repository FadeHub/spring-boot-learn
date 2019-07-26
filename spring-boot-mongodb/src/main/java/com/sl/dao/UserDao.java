package com.sl.dao;

import com.sl.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author shuliangzhao
 * @Title: UserDao
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/26 22:24
 */
public interface UserDao extends MongoRepository<User,String> {

    User findByNameEquals(String name);
}
