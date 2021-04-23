package com.sl.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author shuliangzhao
 * @Title: User
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/23 15:57
 */
@Data
@Builder
public class User {

    private String userName;

    private String age;

    public static void main(String[] args) {
        User wq = User.builder().userName("wq").age("12").build();
    }

}
