package com.review.shares.resource.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Slf4j
@RestController
//跨域
@CrossOrigin
@RequestMapping("/upload")
public class ImageController {

    @Value("${shares.resource.path}")
    private File resourcePath;
    @Value("${shares.resource.host}")
    private String resourceHost;

    @PostMapping("")
    public String uploadFile(MultipartFile imageFile) throws IOException {
        //根据日期获得日期路径
        String path = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDate.now());
        File folder = new File(resourcePath, path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        //获取原始文件名
        String fileName = imageFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf("."));
        String name = UUID.randomUUID().toString() + ext;
        File file = new File(folder, name);
        imageFile.transferTo(file);
        log.debug("保存的实际路径：{}", file.getAbsolutePath());
        String url = resourceHost + "/" + path + "/" + name;
//        System.out.println(url);
        return url;
    }

}
