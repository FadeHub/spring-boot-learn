package com.sl.global;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * 返回一个页面
 * @author shuliangzhao
 * @Title: CustomerExceptionHtmlHandler
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/20 11:31
 */
@ControllerAdvice
public class CustomerExceptionHtmlHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView uploadException(MaxUploadSizeExceededException e) throws IOException {
       ModelAndView view = new ModelAndView();
       view.addObject("msg","上传文件超限");
       view.setViewName("/error");
       return view;
    }
}
