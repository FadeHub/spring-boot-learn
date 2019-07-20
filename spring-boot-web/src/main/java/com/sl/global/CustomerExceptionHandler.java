package com.sl.global;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author shuliangzhao
 * @Title: CustomerExceptionHandler
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/20 11:19
 */
/*
@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public void uploadException(MaxUploadSizeExceededException e, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write("上传文件大小超限");
        out.flush();
        out.close();
    }
}
*/
