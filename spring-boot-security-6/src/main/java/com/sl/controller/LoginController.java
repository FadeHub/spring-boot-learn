package com.sl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: LoginController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/3 14:38
 */
@Controller
public class LoginController {

    @Autowired
    private SessionRegistry sessionRegistry;

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

    @RequestMapping("/login/invalid")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public String invalid() {
        return "Session 已过期，请重新登录";
    }

    @GetMapping("/click")
    @ResponseBody
    public String removeUserSessionByUsername(@RequestParam String username) {
        int count = 0;
        List<Object> users = sessionRegistry.getAllPrincipals();
        for (Object user:users) {
            if (user instanceof User) {
                String principalName  = ((User) user).getUsername();
                if (principalName.equals(username)) {
                    List<SessionInformation> allSessions = sessionRegistry.getAllSessions(user, false);
                    if (allSessions != null && allSessions.size() > 0) {
                        for (SessionInformation sessionInformation:allSessions) {
                            sessionInformation.expireNow();
                            count++;
                        }
                    }
                }
            }
        }
        return "操作成功，清理session共" + count + "个";
    }
}
