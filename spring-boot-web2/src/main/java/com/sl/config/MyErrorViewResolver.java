package com.sl.config;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 自定义视图
 * @author shuliangzhao
 * @Title: MyerrorViewResolver
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/20 18:44
 */
@Component
public class MyErrorViewResolver implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView("errorPage");
        modelAndView.addObject("custommsg","出错了");
        modelAndView.addAllObjects(model);
        return modelAndView;
    }
}
