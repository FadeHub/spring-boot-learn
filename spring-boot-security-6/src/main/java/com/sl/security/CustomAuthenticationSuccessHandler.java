package com.sl.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shuliangzhao
 * @Title: CustomAuthenticationSuccessHandler
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/7 21:53
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private  Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("登录成功,{}", authentication);

        response.sendRedirect("/");
    }
}
