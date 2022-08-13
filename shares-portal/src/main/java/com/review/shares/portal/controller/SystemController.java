package com.review.shares.portal.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.review.shares.portal.service.IUserService;
import com.review.shares.portal.vo.RegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SystemController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public String RegisterStudent(RegisterVo registerVo){
        log.debug("接受到的表单信息：{}",registerVo);
        try {
            userService.registerStudent(registerVo);
            return "注册完成！";
        }catch (SecurityException e){
            return e.getMessage();
        }

    }

}
