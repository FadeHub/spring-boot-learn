package com.sl.command;

/**
 * 命令模式
 * @author shuliangzhao
 * @Title: Client
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/6/3 22:35
 */
public class Client {

    public static void main(String[] args) {

        LightRecever lightRecever = new LightRecever();
        LightOnCommand lightOnCommand = new LightOnCommand(lightRecever);
        LightOffCommand lightOffCommand = new LightOffCommand(lightRecever);
        RemoteController remoteController = new RemoteController();
        remoteController.setCommand(0,lightOnCommand,lightOffCommand);
        remoteController.onButton(0);
        remoteController.offButton(0);
        remoteController.unButton();

    }
}
