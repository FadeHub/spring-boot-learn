package com.sl.flyweight;

/**
 * @author shuliangzhao
 * @Title: ConcreteWebSite
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/27 21:19
 */
public class ConcreteWebSite extends WebSite{

    public String type = "";

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站的发布形式为：" + type + user.getName()+ "在使用！");
    }
}
