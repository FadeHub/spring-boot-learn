package com.sl.template;

/**
 * 模板方法
 * @author shuliangzhao
 * @Title: SoyaMilk
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/31 20:51
 */
public abstract class SoyaMilk {

    //template 方法
    public final void make() {
        select();
        add();
        soak();
        beat();
    }

    void select() {
        System.out.println("选取做豆浆配料！");
    }

    //加入什么配料
    abstract void add();

    void soak() {
        System.out.println("黄豆和配料开始浸泡");
    }

    void beat() {
        System.out.println("黄豆和配料放到豆浆机里面打碎");
    }
}
