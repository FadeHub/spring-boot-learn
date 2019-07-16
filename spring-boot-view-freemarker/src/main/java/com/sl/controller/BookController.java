package com.sl.controller;

import com.sl.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: BookController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/16 23:22
 */
@Controller
public class BookController {

    @GetMapping("/books")
    public String books(Model model) {
        List<Book> bookList = new ArrayList<>();
        Book book = new Book();
        book.setId(1);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        bookList.add(book);
        Book book1 = new Book();
        book1.setId(2);
        book1.setName("红楼梦");
        book1.setAuthor("曹雪芹");
        bookList.add(book1);
        model.addAttribute("books",bookList);
        return "book";
    }
}
