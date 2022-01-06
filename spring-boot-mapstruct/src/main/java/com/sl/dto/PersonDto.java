package com.sl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @package: com.sl.dto
 * @author: shuliangzhao
 * @description:
 * @date 2022/1/6 21:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonDto {

    private String username;
    private String address;
    private int age;
    private String identityCard;
    private String email;

}
