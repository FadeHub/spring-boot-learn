package com.sl.controller;

import com.sl.annotation.BussLog;
import com.sl.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author shuliangzhao
 * @Title: BookController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/19 23:35
 */
@Controller
public class BookController {

    @GetMapping("/book")
    @ResponseBody
    @BussLog(value = "保存书本")
    public Book book(@RequestParam("str") String str) {
        System.out.println(str);
        Book book = new Book();
        book.setName("平凡的世界");
        book.setAuthor("路遥");
        book.setPrice(1.3f);
        book.setPublicationDate(new Date());
        return book;
    }

    @GetMapping("/view")
    public String view() {
        return "view";
    }
}
