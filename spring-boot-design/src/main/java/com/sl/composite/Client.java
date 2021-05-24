package com.sl.composite;

/**
 * 组合模式
 * @author shuliangzhao
 * @Title: Client
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/24 22:09
 */
public class Client {

    public static void main(String[] args) {

        //创建学校从大到小
        OrganizationComponent university = new University("清华大学", "世界顶级大学");

        //创建学院
        OrganizationComponent computer = new College("计算机学院", "计算机学院");
        OrganizationComponent history = new College("历史学院", "历史学院");

        //创建专业
        OrganizationComponent softWare = new Deparment("软件工程", "软件工程");
        OrganizationComponent netWare = new Deparment("网络工程", "网络工程");
        OrganizationComponent comAndJishu = new Deparment("计算机科学与技术", "计算机科学与技术");

        OrganizationComponent jds = new Deparment("近代史", "近代史");
        OrganizationComponent wgls = new Deparment("外国历史", "外国历史");

        //将专业放到学院里面
        computer.add(softWare);
        computer.add(netWare);
        computer.add(comAndJishu);

        history.add(jds);
        history.add(wgls);

        //将学院放到学校里面
        university.add(computer);
        university.add(history);

        university.print();
    }

}
