package com.sl.service;

import cn.hutool.core.util.RandomUtil;
import com.sl.thread.ThreadPoolFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Classname UploadServie
 * @Description TODO
 * @Date 2021/9/5 18:44
 * @Created by zhaoshuliang
 */
public class UploadService implements Callable<String> {

    private final String saveLocalPath = "D:/java_class/Company/WebRoot/";

    private String saveContextPath = "cnblogs-banner/";

   private MultipartFile file;

    public UploadService(MultipartFile file) {
       this.file = file;
    }

    @Override
    public String call() throws Exception {
        //获取文件名称
        String fileName = file.getOriginalFilename();
        //生成存储路径
        String saveHandlerPath = saveLocalPath + saveContextPath;
        //获得文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        //存储目录
        File parentDir = new File(saveHandlerPath);
        //存储目录是否存在
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }
        //生成文件存储名称
        String fileSaveName = RandomUtil.randomString(7) + System.currentTimeMillis() + prefix;
        try {
            File saveFile = new File(saveHandlerPath, fileSaveName);
            //移动临时文件
            file.transferTo(saveFile);
            saveFile.deleteOnExit();
            return saveFile.getAbsolutePath();
        } catch (IOException e) {
            return null;
        }
    }

}
