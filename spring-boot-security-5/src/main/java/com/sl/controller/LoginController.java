package com.sl.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shuliangzhao
 * @Title: LoginController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/3 14:38
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String showHome() {
        //获取当前用户名
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("当前用户为：------>" + name);
        return "home.html";
    }

    @RequestMapping("/login")
    public String login() {
        return "login.html";
    }

    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_admin')") //判断用户是否有指定权限
    public String printAdmin() {
        return "如果你看见这句话，说明你有ROLE_admin角色";
    }

    @RequestMapping("/user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_user')")
    public String printUser() {
        return "如果你看见这句话，说明你有ROLE_user角色";
    }

    @RequestMapping("/admin/r")
    @ResponseBody
    @PreAuthorize("hasPermission('/admin','r')")
    public String printAdminR() {
        return "如果你看见这句话，说明你访问/admin路径具有r权限";
    }

    @RequestMapping("/admin/c")
    @ResponseBody
    @PreAuthorize("hasPermission('/admin','c')")
    public String printAdminC() {
        return "如果你看见这句话，说明你访问/admin路径具有c权限";
    }

    @RequestMapping("/login/error")
    public void loginError(HttpServletRequest  req, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=utf-8");
        AuthenticationException exception =
                (AuthenticationException) req.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        try {
            resp.getWriter().write(exception.toString());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
