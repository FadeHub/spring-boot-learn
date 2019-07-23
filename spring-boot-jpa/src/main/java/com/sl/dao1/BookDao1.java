package com.sl.dao1;

import com.sl.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shuliangzhao
 * @Title: BookDao1
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/23 23:34
 */
public interface BookDao1 extends JpaRepository<Book,Integer> {
}
