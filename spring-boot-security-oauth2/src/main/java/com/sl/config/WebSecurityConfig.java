package com.sl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author shuliangzhao
 * @Title: WebSecurityConfig
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/4 20:41
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("$2a$10$yjMPY5kUmnK2YRGt5zeaD.eaPHa7.wYxgLPb9pzmJBzDi1spupgty")
                .roles("admin")
                .and()
                .withUser("zhao")
                .password("$2a$10$yjMPY5kUmnK2YRGt5zeaD.eaPHa7.wYxgLPb9pzmJBzDi1spupgty")
                .roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/oauth/**")
                .authorizeRequests()
                .antMatchers("/oauth/**")
                .permitAll()
                .and().csrf().disable();
    }
}
