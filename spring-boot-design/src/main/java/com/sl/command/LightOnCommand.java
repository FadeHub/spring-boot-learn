package com.sl.command;

/**
 * @author shuliangzhao
 * @Title: LightOnCommand
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/6/3 22:23
 */
public class LightOnCommand implements Command{

    private LightRecever lightRecever;

    public LightOnCommand(LightRecever lightRecever) {
        this.lightRecever = lightRecever;
    }

    @Override
    public void execute() {
       lightRecever.on();
    }

    @Override
    public void undo() {
        lightRecever.off();
    }
}
