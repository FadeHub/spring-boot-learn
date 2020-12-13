package com.sl.common;

/**
 * @author shuliangzhao
 * @Title: SyncConstants
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/12 19:22
 */
public class SyncConstants {

    // *****返回字符串常量
    /**
     * 返回值字符串resultStr
     */
    public static final String STR_RETURN_RESULT = "resultStr";
    /**
     * 返回值字符串exitStatus
     */
    public static final String STR_RETURN_EXITSTATUS = "exitStatus";

    //*****需替换的字符串常量
    /**
     * csv文件中null值
     */
    public static final String STR_CSV_NULL = "\\N";


    //********* cdc_temp 字段常量名

    /**
     * 字符串：LAST_UPDATE_TIME
     */
    public static final String STR_LAST_UPDATE_TIME = "lastUpdateTime";
    /**
     * 字符串：ROLL_BACK_NUM
     */
    public static final String STR_ROLL_BACK_NUM = "rollBackNum";
    /**
     * 字符串：AHEAD_STEP_NUM
     */
    public static final String STR_AHEAD_STEP_NUM = "aheadStepNum";


    //********* cdc_temp status字段常量
    /**
     * 字符串：初始状态
     */
    public static final String STR_STATUS_INIT = "INIT";
    /**
     * 字符串：失败状态
     */
    public static final String STR_STATUS_FAILED = "FAILED";
    /**
     * 字符串：完成状态
     */
    public static final String STR_STATUS_COMPLETED = "COMPLETED";

}
