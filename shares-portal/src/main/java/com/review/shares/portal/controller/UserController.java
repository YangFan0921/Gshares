package com.review.shares.portal.controller;


import com.review.shares.portal.model.User;
import com.review.shares.portal.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
