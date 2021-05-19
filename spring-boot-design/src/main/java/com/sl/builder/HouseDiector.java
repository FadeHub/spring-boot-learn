package com.sl.builder;

/**
 * @author shuliangzhao
 * @Title: HouseDiector
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/19 22:19
 */
public class HouseDiector {

    AbstractHouseBuilder abstractHouseBuilder;

    public HouseDiector() {
    }

    public HouseDiector(AbstractHouseBuilder abstractHouseBuilder) {
        this.abstractHouseBuilder = abstractHouseBuilder;
    }

    public AbstractHouseBuilder getAbstractHouseBuilder() {
        return abstractHouseBuilder;
    }

    public void setAbstractHouseBuilder(AbstractHouseBuilder abstractHouseBuilder) {
        this.abstractHouseBuilder = abstractHouseBuilder;
    }

    public House buildDiector() {
        return abstractHouseBuilder.build();
    }
}
