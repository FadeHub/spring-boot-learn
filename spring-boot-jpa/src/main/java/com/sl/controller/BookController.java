package com.sl.controller;

import com.sl.dao1.BookDao1;
import com.sl.dao2.BookDao2;
import com.sl.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuliangzhao
 * @Title: BookController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/23 23:36
 */
@RestController
public class BookController {

    @Autowired
    private BookDao1 bookDao1;

    @Autowired
    private BookDao2 bookDao2;

    @GetMapping("/save")
    public void save() {
        Book book = new Book();
        book.setAuthor("路遥");
        book.setName("平凡的世界");
        bookDao1.save(book);
        book = new Book();
        book.setAuthor("韩寒");
        book.setName("三重门");
        bookDao2.save(book);
    }
}
