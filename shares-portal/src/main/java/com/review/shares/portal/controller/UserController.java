package com.review.shares.portal.controller;


import com.review.shares.portal.model.User;
import com.review.shares.portal.service.IUserService;
import com.review.shares.portal.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
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
public class UserController {
    @Autowired
    IUserService userService;

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
