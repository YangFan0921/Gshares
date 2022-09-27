package com.review.shares.sys.controller;


import com.review.shares.commons.model.User;
import com.review.shares.sys.service.IUserService;
import com.review.shares.sys.vo.RegisterVo;
import com.review.shares.sys.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@RestController
@RequestMapping("/v1/users")
@Slf4j
public class UserController {

    @Autowired
    IUserService userService;

    //@Validated启用Spring Validation框架对RegisterVo参数进行验证
    //BindingResult保存验证结果
    @PostMapping("/register")
    public String RegisterStudent(@Validated RegisterVo registerVo, BindingResult result) {
        log.debug("接受到的表单信息：{}", registerVo);
        if (result.hasErrors()) {
            String msg = result.getFieldError().getDefaultMessage();
            return msg;
        }
        userService.registerStudent(registerVo);
        return "注册完成！";
    }

    @GetMapping("/master")
    public List<User> getTeachers(){
        return userService.getTeachers();
    }

    //首页用户信息面板
    @GetMapping("/me")
    public UserVo getUserVo(@AuthenticationPrincipal UserDetails user){
        UserVo userVo = userService.getCurrentUserVo(user.getUsername());
        return userVo;
    }





}
