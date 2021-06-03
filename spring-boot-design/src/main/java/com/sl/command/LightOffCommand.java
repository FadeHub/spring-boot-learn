package com.sl.command;

/**
 * @author shuliangzhao
 * @Title: LightOffCommand
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/6/3 22:24
 */
public class LightOffCommand implements Command{

    LightRecever lightRecever;

    public LightOffCommand(LightRecever lightRecever) {
        this.lightRecever = lightRecever;
    }

    @Override
    public void execute() {
        lightRecever.off();
    }

    @Override
    public void undo() {
        lightRecever.on();
    }
}
