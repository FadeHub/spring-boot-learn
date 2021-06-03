package com.sl.command;

/**
 * 命令发起者
 * @author shuliangzhao
 * @Title: RemoteController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/6/3 22:25
 */
public class RemoteController {

    Command[] onCommands;
    Command[] offCommands;

    //执行撤销命令
    Command unCommand;

    //完成按钮初始化


    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];

        //初始化按钮
        for (int i = 0; i < 5; i++) {
            onCommands[i] = new UnCommand();
            offCommands[i] = new UnCommand();
        }
    }

    //给按钮设置命令
    public void setCommand(int no,Command onCommand,Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    //按下开按钮
    public void onButton(int no) {
        onCommands[no].execute();
        //记住撤回按钮
        unCommand = onCommands[no];
    }

    //按下关按钮
    public void offButton(int no) {
        offCommands[no].execute();
        unCommand = offCommands[no];
    }

    //按下撤销按钮
    public void unButton() {
        unCommand.undo();
    }
}
