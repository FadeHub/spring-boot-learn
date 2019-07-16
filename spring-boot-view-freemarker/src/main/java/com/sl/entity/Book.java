package com.sl.entity;

/**
 * @author shuliangzhao
 * @Title: Book
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/16 23:21
 */
public class Book {

    private Integer id;

    private String name;

    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
