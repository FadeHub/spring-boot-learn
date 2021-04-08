package com.sl.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author shuliangzhao
 * @Title: TestCeph
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/26 15:26
 */
public class ObsCephService {

    public CephObject download() throws FileNotFoundException {
        CephObject cephObject = new CephObject();
        cephObject.setFilterInputStream(new S3InputStrem(new FileInputStream("")));
        return  cephObject;
    }
}
