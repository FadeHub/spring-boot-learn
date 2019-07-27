package com.sl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shuliangzhao
 * @Title: RedisSessionController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/27 18:27
 */
@RestController
@RequestMapping(value = "/admin/v1")
public class RedisSessionController {
    @GetMapping(value = "/first")
    public Map<String, Object> firstResp (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("requestUrl", request.getRequestURL());
        map.put("requestUrl", request.getRequestURL());
        return map;
    }

    @GetMapping(value = "/sessions")
    public Object sessions (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("requestUrl"));
        return map;
    }

}
