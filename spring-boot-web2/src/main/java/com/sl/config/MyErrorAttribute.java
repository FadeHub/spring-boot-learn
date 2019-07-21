package com.sl.config;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 自定义error数据
 * @author shuliangzhao
 * @Title: MyErrorAttribute
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/20 18:26
 */
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {


    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("custommsg","出错了");
        errorAttributes.remove("error");
        return errorAttributes;
    }
}
