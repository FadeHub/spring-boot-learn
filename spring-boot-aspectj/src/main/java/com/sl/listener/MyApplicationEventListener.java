package com.sl.listener;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


/**
 * @author shuliangzhao
 * @Title: MyApplicationEventListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/17 20:24
 */
@Component
public class MyApplicationEventListener implements ApplicationListener<ApplicationReadyEvent> {


    @Resource(name = "targetSqlSessionTemplate")
    private SqlSessionTemplate targetSqlSessionTemplate;

    @Resource(name = "midSqlSessionTemplate")
    private SqlSessionTemplate midSqlSessionTemplate;

    //包名 不同的包名以逗号分隔
    @Value("{taget.source}")
    private String targetSource;

    //包名
    @Value("{mid.source}")
    private String midSource;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        ConfigurableApplicationContext applicationContext = applicationReadyEvent.getApplicationContext();
        Map<String, SqlSessionDaoSupport> beanMap = applicationContext.getBeansOfType(SqlSessionDaoSupport.class);
        String[] targetScanPath = targetSource.split(",");
        String[] midScanPath = midSource.split(",");
        List<String> targetList = Arrays.asList(targetScanPath);
        List<String> midList = Arrays.asList(midScanPath);
        beanMap.forEach((k,v) -> {
            String name = v.getClass().getPackage().getName();
            if (targetList.contains(name)) {
                v.setSqlSessionTemplate(targetSqlSessionTemplate);
            }else if (midList.contains(name)) {
                v.setSqlSessionTemplate(midSqlSessionTemplate);
            }
        } );
    }
}
