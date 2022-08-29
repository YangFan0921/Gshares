package com.review.shares.portal.controller;

import com.review.shares.portal.service.IUserService;
import com.review.shares.portal.vo.RegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
@Slf4j
public class SystemController {

    @Autowired
    private IUserService userService;


    //@Validated启用Spring Validation框架对RegisterVo参数进行验证
    //BindingResult保存验证结果
    @PostMapping("/register")
    public String RegisterStudent(@Validated RegisterVo registerVo, BindingResult result){
        log.debug("接受到的表单信息：{}",registerVo);
        if (result.hasErrors()){
            String msg = result.getFieldError().getDefaultMessage();
            return msg;
        }

        userService.registerStudent(registerVo);
        return "注册完成！";
    }


    @Value("${shares.resource.path}")
    private File resourcePath;
    @Value("${shares.resource.host}")
    private String resourceHost;

    @PostMapping("/upload/file")
    public String uploadFile(MultipartFile imageFile) throws IOException {
        //根据日期获得日期路径
        String path = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDate.now());
        File folder = new File(resourcePath,path);
        if ( !folder.exists() ){
            folder.mkdirs();
        }
        //获取原始文件名
        String fileName = imageFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf("."));
        String name = UUID.randomUUID().toString()+ext;
        File file = new File(folder,name);
        imageFile.transferTo(file);
        log.debug("保存的实际路径：{}",file.getAbsolutePath());
        String url = resourceHost + "/" + path + "/" +name;
//        System.out.println(url);
        return url;
    }

}
