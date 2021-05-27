package com.sl.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuliangzhao
 * @Title: WebSiteFactory
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/27 21:20
 */
public class WebSiteFactory {

    private Map<String,ConcreteWebSite> map = new HashMap<>();

    public WebSite getWebSite(String type) {
        if (!map.containsKey(type)){
            map.put(type,new ConcreteWebSite(type));
        }
        return map.get(type);
    }

    public Integer getWebSiteCount() {
        return map.size();
    }

}
