package com.sl.base.listener;

import com.sl.base.BaseException;
import org.slf4j.Logger;

/**
 * @author shuliangzhao
 * @Title: BaseRpwListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/1 19:56
 */
public interface BaseRpwListener {

    default void handler(Logger logger,Exception e) {
        if (e instanceof BaseException) {
             logger.error("业务异常！"+e.getMessage(),e);
        } else {
             logger.error("非业务异常！"+e.getMessage(),e);
        }
    }
}
