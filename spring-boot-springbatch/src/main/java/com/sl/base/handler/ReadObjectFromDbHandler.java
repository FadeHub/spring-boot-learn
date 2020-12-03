package com.sl.base.handler;

/**
 * 读取文件对象接口
 * @author shuliangzhao
 * @Title: ReadObjectFromDbHandler
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/1 20:43
 */
public interface ReadObjectFromDbHandler {

    String queryId();

    int pageSize();
}
