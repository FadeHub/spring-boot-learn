package com.sl.facade;

/**
 * 外观类模式
 * @author shuliangzhao
 * @Title: Client
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/25 22:58
 */
public class Client {

    public static void main(String[] args) {
        HomeFacade homeFacade = new HomeFacade();
        homeFacade.ready();
        homeFacade.play();
    }
}
