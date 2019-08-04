package com.sl.security;


import com.sl.config.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shuliangzhao
 * @Title: CustomAuthenticationProvider
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/4 17:20
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取用户输入的用户名和密码
        String name = authentication.getName();
        String inputPassword = authentication.getCredentials().toString();
        CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) authentication.getDetails();
        String verifyCode = details.getVerifyCode();
        if(!validateVerify(verifyCode)) {
            throw new DisabledException("验证码输入错误");
        }
        //userDetails为数据库中查询到的用户信息
        UserDetails userDetails = userDetailsService.loadUserByUsername(name);
        if (!userDetails.getPassword().equals(inputPassword)) {
            throw new BadCredentialsException("密码错误");
        }
        return new UsernamePasswordAuthenticationToken(name, inputPassword, userDetails.getAuthorities());
    }


    private boolean validateVerify(String verifyCode) {
            //获取当前线程绑定的request对象
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String validateCode = ((String)request.getSession().getAttribute("validateCode")).toUpperCase();
            verifyCode = verifyCode.toUpperCase();
            System.out.println("验证码：" + validateCode + "用户输入：" + verifyCode);
            return validateCode.equals(verifyCode);
    }


    @Override
    public boolean supports(Class<?> authentication) {
        // 这里不要忘记，和UsernamePasswordAuthenticationToken比较
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
