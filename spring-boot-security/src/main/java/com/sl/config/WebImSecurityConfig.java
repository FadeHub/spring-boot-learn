package com.sl.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于内存认证
 * @author shuliangzhao
 * @Title: MyWebSecurityConfig
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/30 22:16
 */
//@Configuration
public class WebImSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    //配置基于内存认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin")
                .password("123").roles("ADMIN","USER")
                .and()
                .withUser("zhao")
                .password("123").roles("USER");
    }

    //配置HttpSecurity
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .antMatchers("/user/**")
                .access("hasAnyRole('ADMIN','USER')")
                .antMatchers("/db/**")
                .access("hasRole('ADMIN') and hasRole('DBA')")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("name")
                .passwordParameter("passwd")
                .successHandler(new AuthenticationSuccessHandler() {//登录成功
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        Object principal = authentication.getPrincipal();
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        resp.setStatus(200);
                        Map<String,Object> map = new HashMap<>();
                        map.put("status",200);
                        map.put("msg",principal);
                        ObjectMapper om = new ObjectMapper();
                        out.write(om.writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {//登录失败
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        resp.setStatus(401);
                        Map<String,Object> map = new HashMap<>();
                        map.put("status",401);
                        if(e instanceof LockedException) {
                            map.put("msg","账户被锁定，登录失败！");
                        }else if (e instanceof BadCredentialsException) {
                            map.put("msg","账户密码输入错误，登录失败！");
                        }else if (e instanceof BadCredentialsException) {
                            map.put("msg","账户密码输入错误，登录失败！");
                        }else if (e instanceof DisabledException) {
                            map.put("msg","账户被禁用，登录失败！");
                        }else if (e instanceof AccountExpiredException) {
                            map.put("msg","账户已过期，登录失败！");
                        }else if (e instanceof CredentialsExpiredException) {
                            map.put("msg","密码已过期，登录失败！");
                        }else {
                            map.put("msg","登录失败");
                        }
                        ObjectMapper om = new ObjectMapper();
                        out.write(om.writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .addLogoutHandler(new LogoutHandler() {//退出
                    @Override
                    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {

                    }
                })
                .logoutSuccessHandler(new LogoutSuccessHandler() {//退出成功
            @Override
            public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                httpServletResponse.sendRedirect("/login_page");
            }
        })
                .permitAll()
                .and()
                .csrf()
                .disable();

    }
}
