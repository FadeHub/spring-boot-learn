package com.sl.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author shuliangzhao
 * @Title: GlobalController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/20 12:05
 */
@RestController
public class GlobalController {

    @GetMapping("/global")
    public void globalParma(Model model) {
        Map<String, Object> map = model.asMap();
        Set<String> strings =  map.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            Object o = map.get(next);
            System.out.println(next + ">>>>>>" + o);
        }
    }
}
