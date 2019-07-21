package com.sl.controller;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 数据和视图全部自定义
 * @author shuliangzhao
 * @Title: MyErrorController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/20 18:53
 */
@Controller
public class MyErrorController extends BasicErrorController {
    public MyErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties,
                             List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes,serverProperties.getError(),errorViewResolvers);
    }

    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        Map<String, Object> model =
                getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
        model.put("custommsg","出错了");
        ModelAndView modelAndView = new ModelAndView("myErrorPage",model,status);
        return modelAndView;
    }

    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> errorAttributes = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        errorAttributes.put("custommsg","出错了");
        HttpStatus status = getStatus(request);
        return  new ResponseEntity<>(errorAttributes,status);
    }
}
