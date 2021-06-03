package com.sl.command;

/**
 * 命令模式
 * @author shuliangzhao
 * @Title: Command
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/6/3 22:11
 */
public interface Command {

    void execute();

    //撤销
    void undo();

}
