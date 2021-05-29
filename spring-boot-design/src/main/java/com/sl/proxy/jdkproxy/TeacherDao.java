package com.sl.proxy.jdkproxy;

/**
 * @author shuliangzhao
 * @Title: TeacherDao
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/29 13:31
 */
public class TeacherDao implements ITeacherDao{
    @Override
    public void teach() {
        System.out.println("教数学");
    }
}
