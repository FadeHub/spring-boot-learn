package com.sl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author shuliangzhao
 * @Title: RedisSessionConf
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/27 17:32
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConf {
}
