package com.sl.facade;

/**
 * 外观类模式
 * @author shuliangzhao
 * @Title: HomeFacade
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/25 22:48
 */
public class HomeFacade {

    private DvDplayer dvDplayer;
    private Popcorn popcorn;
    private Projector projector;
    private Screen screen;
    private Stereo stereo;
    private TheaterLight theaterLight;

    public HomeFacade() {
        this.dvDplayer = DvDplayer.getInstance();
        this.popcorn = Popcorn.getInstance();
        this.projector = Projector.getInstance();
        this.screen = Screen.getInstance();
        this.stereo = Stereo.getInstance();
        this.theaterLight = TheaterLight.getInstance();
    }

    public void ready() {
        popcorn.on();
        popcorn.pop();
        screen.down();
        projector.on();
        stereo.on();
        dvDplayer.on();
        theaterLight.dim();
    }

    public void play() {
        dvDplayer.play();
    }

    public void pause() {
        dvDplayer.pause();
    }

    public void end() {
        popcorn.off();
        theaterLight.bright();
        screen.up();
        projector.off();
        stereo.off();
        dvDplayer.off();
    }
}
