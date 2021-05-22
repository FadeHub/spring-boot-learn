package com.sl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author shuliangzhao
 * @Title: SecurityConfig
 * @ProjectName SpringSecurityDemo
 * @Description: TODO
 * @date 2021/5/19 14:28
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Override //基于配置类
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("123");
        auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder()).withUser("wangwu").password(password).roles("admin");
    }*/

    @Autowired
    private DataSource dataSource;

    //设置自动登录
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setCreateTableOnStartup(true);
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //退出操作
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login.html").permitAll();

        http.exceptionHandling().accessDeniedPage("/unauth.html");//无权限访问跳转这个页面
        http.formLogin()
                .loginPage("/login.html") //自己登录页面
                .loginProcessingUrl("/user/login") //登录访问路径
                .defaultSuccessUrl("/success.html").permitAll()  //登录成功跳转路径
                .and().authorizeRequests()
                .antMatchers("/","/user/login")//设置哪些路径可以直接访问，不需要认证
                .permitAll()
                .antMatchers("/user/index").hasAnyRole("USER,ADMIN")
                .anyRequest().authenticated()
                .and()
                .rememberMe().tokenRepository(persistentTokenRepository())//自动登录
                .userDetailsService(userDetailsService).tokenValiditySeconds(60)
                .and().csrf().disable(); //关闭csrf保护
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean matches = passwordEncoder.matches("123", "$2a$10$CYX9OMv0yO8wR8rE19N2fOaXDJondci5uR68k2eQJm50q8ESsDMlC");
        System.out.println(matches);
    }
}
