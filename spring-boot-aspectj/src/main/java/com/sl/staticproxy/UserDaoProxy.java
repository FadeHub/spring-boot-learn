package com.sl.staticproxy;

/**
 * 代理对象
 * @author shuliangzhao
 * @Title: UserDaoProxy
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/19 17:03
 */
public class UserDaoProxy implements UserDao {

    private UserDao target;

    public UserDaoProxy(UserDao target) {
        this.target = target;
    }

    @Override
    public void delete() {
        System.out.println("开始操作");
        target.delete();
        System.out.println("结束操作");
    }
}
