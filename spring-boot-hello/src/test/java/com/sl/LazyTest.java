package com.sl;

import com.sl.controller.MyLazy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shuliangzhao
 * @Title: LazyTest
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/10 19:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LazyTest {

    @Autowired
    private MyLazy myLazy;

    @Test
    public void test() {
         myLazy.say();
    }
}
