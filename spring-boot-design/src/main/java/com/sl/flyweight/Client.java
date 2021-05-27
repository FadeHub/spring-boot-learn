package com.sl.flyweight;

/**
 * 享元模式
 * @author shuliangzhao
 * @Title: Client
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/27 21:25
 */
public class Client {

    public static void main(String[] args) {

        WebSiteFactory webSiteFactory = new WebSiteFactory();
        WebSite webSite = webSiteFactory.getWebSite("新浪");
        webSite.use(new User("王五"));

        WebSite webSite1 =webSiteFactory.getWebSite("腾讯");
        webSite1.use(new User("赵六"));

        WebSite webSite2 = webSiteFactory.getWebSite("阿里");
        webSite2.use(new User("李四"));

        WebSite webSite3 = webSiteFactory.getWebSite("新浪");
        webSite3.use(new User("阿七"));

        System.out.println(webSiteFactory.getWebSiteCount());
    }
}
