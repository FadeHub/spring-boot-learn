package com.sl.para;

import com.sl.entity.SysUser;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @package: com.sl.para
 * @author: shuliangzhao
 * @description:
 * @date 2021/12/22 14:04
 */
@Component
public class ParaService {

    public static void main(String[] args) throws Exception {


         Class clz = SysUser.class;
        Object o1 = clz.newInstance();
        Field username = clz.getField("username");
        username.set(o1,"李四");
        Field password = clz.getField("password");
        password.set(o1,"1234");

        Method method = clz.getMethod("setUsername", String.class);
        method.invoke(o1,"张三");
        Method method1 = clz.getMethod("setPassword", String.class);
        method1.invoke(o1,"123");
        System.out.println("初始化对象："+ o1);
    }

}
