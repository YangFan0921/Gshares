package com.review.shares.portal.controller;

import com.review.shares.portal.service.IUserService;
import com.review.shares.portal.vo.RegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
        try {
            userService.registerStudent(registerVo);
            return "注册完成！";
        }catch (SecurityException e){
            return e.getMessage();
        }

    }

}
