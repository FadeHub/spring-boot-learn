package com.sl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @package: com.sl.entity
 * @author: shuliangzhao
 * @description:
 * @date 2022/1/6 21:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

    private String username;
    private String address;
    private int age;
    private String idCard;
    private String email;

}
