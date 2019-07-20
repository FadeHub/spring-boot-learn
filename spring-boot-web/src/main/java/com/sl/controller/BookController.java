package com.sl.controller;

import com.sl.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author shuliangzhao
 * @Title: BookController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/19 23:35
 */
@RestController
public class BookController {

    @GetMapping("/book")
    public Book book() {
        Book book = new Book();
        book.setName("平凡的世界");
        book.setAuthor("路遥");
        book.setPrice(1.3f);
        book.setPublicationDate(new Date());
        return book;
    }
}
