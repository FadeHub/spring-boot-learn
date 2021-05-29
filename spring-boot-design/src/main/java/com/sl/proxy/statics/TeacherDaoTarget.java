package com.sl.proxy.statics;

/**
 * @author shuliangzhao
 * @Title: TeacherDaoTarget
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/29 13:28
 */
public class TeacherDaoTarget implements ITeacherDao{

    private ITeacherDao target;

    public TeacherDaoTarget(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("备课开始");
        target.teach();
        System.out.println("备课结束");
    }
}
