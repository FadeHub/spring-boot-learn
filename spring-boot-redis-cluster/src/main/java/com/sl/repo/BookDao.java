package com.sl.repo;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author shuliangzhao
 * @Title: UseDao
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/28 19:05
 */
@Component
public class BookDao {

    @Cacheable(value = "c1")
    public String getBookId(Integer id) {
        System.out.println("getBookId");
        return "张三";
    }

    @CachePut(value = "c1")
    public String updateBookId(Integer id) {
        return "这是李四";
    }

    @CacheEvict(value = "c1")
    public void deleteById(Integer id) {
        System.out.println("deleteById");
    }

    @Cacheable(value = "c1")
    public String getBookById2(Integer id) {
        System.out.println("getBookById2");
        return "这是李四";
    }

}
