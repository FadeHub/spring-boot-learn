package com.sl.dao2;

import com.sl.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shuliangzhao
 * @Title: BookDao2
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/23 23:35
 */
public interface BookDao2 extends JpaRepository<Book,Integer> {
}
