package com.sl.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author shuliangzhao
 * @Title: UploadController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/20 0:01
 */
@RestController
public class UploadController {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    @PostMapping("/upload")
    public String upload(MultipartFile multipartFile, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        String oldName = multipartFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());
        try {
            multipartFile.transferTo(new File(folder,newName));
            String filePath = request.getScheme() + "://" + request.getServerName() +
                    ":" + request.getServerPort() + "/uploadFile/" +format +"/"+ newName;
            return filePath;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}
