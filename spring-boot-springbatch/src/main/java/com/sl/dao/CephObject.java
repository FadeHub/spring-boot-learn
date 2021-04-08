package com.sl.dao;

import java.io.FilterInputStream;

/**
 * @author shuliangzhao
 * @Title: CephObject
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/26 15:25
 */
public class CephObject {

    private FilterInputStream filterInputStream;

    public FilterInputStream getFilterInputStream() {
        return filterInputStream;
    }

    public void setFilterInputStream(FilterInputStream filterInputStream) {
        this.filterInputStream = filterInputStream;
    }
}
