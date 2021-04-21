package com.sl;

import com.sl.entity.User;
import com.sl.mapper.BookMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shuliangzhao
 * @Title: TranscationTest
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/11/9 13:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMybatisaplication.class)
public class TranscationTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void test() {
         testSave();
    }


    @Transactional
    public void testSave() {
        System.out.println("开启事物");
        User user = new User();
        user.setName("张三");
        user.setAge("12");
        bookMapper.insert(user);
    }
}
