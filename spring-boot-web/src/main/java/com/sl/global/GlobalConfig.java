package com.sl.global;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuliangzhao
 * @Title: GlobalConfig
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/20 12:02
 */
@ControllerAdvice
public class GlobalConfig {

    @ModelAttribute(value = "info")
    public Map<String,String> userInfo() {
        Map<String,String> map = new HashMap<>();
        map.put("usename","路遥");
        map.put("gender","男");
        return map;
    }
}
