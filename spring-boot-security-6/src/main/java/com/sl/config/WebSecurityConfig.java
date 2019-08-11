package com.sl.config;

import com.sl.security.CustomAuthenticationFailureHandler;
import com.sl.security.CustomAuthenticationSuccessHandler;
import com.sl.security.CustomExpiredSessionStrategy;
import com.sl.security.CustomLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author shuliangzhao
 * @Title: WebSecurityConfig
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/3 14:54
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    private CustomExpiredSessionStrategy customExpiredSessionStrategy;

    @Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString());
            }
        });
    }


   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 如果有允许匿名的url，填在下面
                //.antMatchers().permitAll()
                .anyRequest().authenticated().and()

                // 设置登陆页
                .formLogin().loginPage("/login")
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler)
//                .failureUrl("/login/error")
//                .defaultSuccessUrl("/")
                .permitAll();

        http.csrf().disable();
    }*/


      //Session超时设置
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 如果有允许匿名的url，填在下面
                .antMatchers("/login/invalid").permitAll()
                .anyRequest().authenticated().and()

                // 设置登陆页
                .formLogin().loginPage("/login")
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler)
                .permitAll()
                .and()
//                .failureUrl("/login/error")
//                .defaultSuccessUrl("/")
                .sessionManagement()
                .invalidSessionUrl("/login/invalid");

        http.csrf().disable();
    }*/

    //   限制最大登录数
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 如果有允许匿名的url，填在下面
                .antMatchers("/login/invalid").permitAll()
                .anyRequest().authenticated().and()

                // 设置登陆页
                .formLogin().loginPage("/login")
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler)
                .permitAll()
                .and()
//                .failureUrl("/login/error")
//                .defaultSuccessUrl("/")
                .sessionManagement()
                .invalidSessionUrl("/login/invalid")
                //指定最大登录数
                .maximumSessions(1)
                //当达到最大值时，是否保留已经登录的用户
                .maxSessionsPreventsLogin(false)
                //当达到最大值时，旧用户被踢出后的操作
                .expiredSessionStrategy(customExpiredSessionStrategy);

        http.csrf().disable();
    }*/

    //踢出用户
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 如果有允许匿名的url，填在下面
                .antMatchers("/login/invalid").permitAll()
                .anyRequest().authenticated().and()

                // 设置登陆页
                .formLogin().loginPage("/login")
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler)
                .permitAll()
                .and()
//                .failureUrl("/login/error")
//                .defaultSuccessUrl("/")
                .sessionManagement()
                .invalidSessionUrl("/login/invalid")
                //指定最大登录数
                .maximumSessions(1)
                //当达到最大值时，是否保留已经登录的用户
                .maxSessionsPreventsLogin(false)
                //当达到最大值时，旧用户被踢出后的操作
                .expiredSessionStrategy(customExpiredSessionStrategy)
                .sessionRegistry(sessionRegistry());

        http.csrf().disable();
    }*/

     //退出登录
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 如果有允许匿名的url，填在下面
                .antMatchers("/login/invalid").permitAll()
                .anyRequest().authenticated().and()

                // 设置登陆页
                .formLogin().loginPage("/login")
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/signout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(customLogoutSuccessHandler)
                .and()
//                .failureUrl("/login/error")
//                .defaultSuccessUrl("/")
                .sessionManagement()
                .invalidSessionUrl("/login/invalid")
                //指定最大登录数
                .maximumSessions(1)
                //当达到最大值时，是否保留已经登录的用户
                .maxSessionsPreventsLogin(false)
                //当达到最大值时，旧用户被踢出后的操作
                .expiredSessionStrategy(customExpiredSessionStrategy)
                .sessionRegistry(sessionRegistry());

        http.csrf().disable();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/css/**", "/js/**");
    }

}
