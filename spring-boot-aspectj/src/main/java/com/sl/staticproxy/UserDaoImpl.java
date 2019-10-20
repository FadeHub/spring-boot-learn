package com.sl.staticproxy;

/**
 * @author shuliangzhao
 * @Title: UserDaoImpl
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/19 17:02
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void delete() {
        System.out.println("删除数据");
    }
}
