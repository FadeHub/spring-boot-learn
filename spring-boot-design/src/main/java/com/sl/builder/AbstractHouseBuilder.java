package com.sl.builder;

/**
 * @author shuliangzhao
 * @Title: AbstractHouseBuilder
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/19 22:11
 */
public abstract class AbstractHouseBuilder {

    protected abstract String builderBaise();

    protected abstract String builderWall();

    protected abstract String builderRoofed();

    protected abstract House build();

}
