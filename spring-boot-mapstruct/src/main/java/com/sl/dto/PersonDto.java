package com.sl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;

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

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
//        Set<Integer> set = new HashSet<Integer>();
//        List<Integer> list = new ArrayList<>();
//        for (int i:nums) {
//            if (set.contains(i)) {
//                list.add(i);
//               continue;
//            }
//            set.add(i);
//        }
//        System.out.println(list);
        int repeatNumber = findRepeatNumber(nums);
        System.out.println(repeatNumber);
    }

    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i:nums) {
            if (set.contains(i)) {
                return i;
            }
            set.add(i);
        }
        return -1;
    }
}
