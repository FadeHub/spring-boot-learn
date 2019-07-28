package com.sl;

import com.sl.entity.User;
import com.sl.repo.BookDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shuliangzhao
 * @Title: RedisClusterCacheApplicationTest
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/28 19:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClusterCacheApplicationTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void test() {
        bookDao.getBookId(10);
        String book = bookDao.getBookId(100);
        System.out.println(book);
        bookDao.updateBookId(100);
        String bookId = bookDao.getBookId(100);
        System.out.println(bookId);
        bookDao.deleteById(100);
        bookDao.getBookId(100);
        bookDao.getBookById2(99);
    }
}
