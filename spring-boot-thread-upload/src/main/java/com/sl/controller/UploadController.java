package com.sl.controller;

import com.sl.service.MultiUploadService;
import com.sl.service.UploadService;
import com.sl.util.TimeUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UploadController
 * @Description TODO
 * @Date 2021/9/5 16:58
 * @Created by zhaoshuliang
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping("/single")
    public ResponseEntity<List<String>> singleUpload(MultipartFile[] files) {
        List<String> list = new ArrayList<>();
        TimeUtil.times("单线程上传测试",() -> {
            for (MultipartFile file:files) {
                try {
                    String path = new UploadService(file).call();
                    list.add(path);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        return  ResponseEntity.ok(list);
    }

    @PostMapping("/multi")
    public ResponseEntity<List<String>> multiUpload(MultipartFile[] files) {
        List<String> list = new ArrayList<>();
        TimeUtil.times("多线程上传测试",() ->{
            List<String> strings = MultiUploadService.multiUpload(files);
            list.addAll(strings);
        });
        return ResponseEntity.ok(list);
    }

}
