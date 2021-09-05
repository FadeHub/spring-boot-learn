package com.sl.service;

import com.sl.thread.ThreadPoolFactory;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Classname MultiUploadService
 * @Description TODO
 * @Date 2021/9/5 19:05
 * @Created by zhaoshuliang
 */
public class MultiUploadService {

    public static List<String> multiUpload(MultipartFile[] files) {
        List<String> list = new ArrayList<>();
        try {
            int length = files.length;
            final BlockingDeque<Future<String>> queue = new LinkedBlockingDeque<>(length);
            final CompletionService<String> completionService = new ExecutorCompletionService<>(ThreadPoolFactory.getInstance(),queue);
            for (MultipartFile file:files) {
                completionService.submit(new UploadService(file));
            }

            for (int i = 0;i < length;i++) {
                Future<String> future = completionService.take();
                String url = future.get();
                list.add(url);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
