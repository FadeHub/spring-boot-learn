package com.sl.proxy.statics;

/**
 * @author shuliangzhao
 * @Title: TeacherDao
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/29 13:27
 */
public class TeacherDao implements ITeacherDao{
    @Override
    public void teach() {
        System.out.println("正在教语文...");
    }
}
