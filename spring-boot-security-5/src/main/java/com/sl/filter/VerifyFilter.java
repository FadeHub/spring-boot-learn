package com.sl.filter;

import org.springframework.security.authentication.DisabledException;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 基于filter做的验证码
 * 该 Filter 保证每次请求一定会过滤
 * @author shuliangzhao
 * @Title: VerifyFilter
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/4 16:58
 */
public class VerifyFilter extends OncePerRequestFilter {

    private static final PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws ServletException, IOException {
        if (isProtectedUrl(req)) {
            String verifyCode = req.getParameter("verifyCode");
            if (!validateVerify(verifyCode)) {
                //手动设置异常
                req.setAttribute("SPRING_SECURITY_LAST_EXCEPTION",new DisabledException("验证码输入错误"));
                // 转发到错误Url
                req.getRequestDispatcher("/login/error").forward(req,resp);
            } else {
                filterChain.doFilter(req,resp);
            }
        } else {
            filterChain.doFilter(req,resp);
        }
    }

    private boolean validateVerify(String verifyCode) {
        //获取当前线程绑定的request对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String validateCode = ((String)request.getSession().getAttribute("validateCode")).toUpperCase();
        verifyCode = verifyCode.toUpperCase();
        System.out.println("验证码：" + validateCode + "用户输入：" + verifyCode);
        return validateCode.equals(verifyCode);
    }

    // 拦截 /login的POST请求
    private boolean isProtectedUrl(HttpServletRequest req) {
        return "POST".equals(req.getMethod()) && pathMatcher.match("/login",req.getServletPath());
    }
}
