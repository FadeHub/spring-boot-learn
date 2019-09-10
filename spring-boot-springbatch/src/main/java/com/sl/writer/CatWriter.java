package com.sl.writer;

import com.sl.entity.Cat;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


/**
 * @author shuliangzhao
 * @Title: CatWriter
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/10 20:33
 */
@Component
@StepScope
public class CatWriter implements ItemWriter<Cat> {

    private MyBatisBatchItemWriter<Cat> catMyBatisBatchItemWriter = new MyBatisBatchItemWriter<Cat>();

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void init() {
        catMyBatisBatchItemWriter.setSqlSessionFactory(sqlSessionFactory);
        catMyBatisBatchItemWriter.setStatementId("com.sl.entity." + Cat.class.getSimpleName() + ".insertCat");
        catMyBatisBatchItemWriter.setAssertUpdates(false);
    }

    @Override
    public void write(List<? extends Cat> list) throws Exception {
       catMyBatisBatchItemWriter.write(list);
    }
}
