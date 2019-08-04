package com.sl;

import com.sl.servlet.VerifyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 自动登录
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
         ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new VerifyServlet());
         servletRegistrationBean.addUrlMappings("/getVerifyCode");
         return servletRegistrationBean;
    }
}
