package com.sl.proxy.statics;

/**
 * @author shuliangzhao
 * @Title: Client
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/29 13:29
 */
public class Client {

    public static void main(String[] args) {
        ITeacherDao target = new TeacherDao();
        new TeacherDaoTarget(target).teach();
    }
}
