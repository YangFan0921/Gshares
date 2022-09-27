package com.review.shares.sys.controller;

import com.review.shares.commons.model.Permission;
import com.review.shares.commons.model.Role;
import com.review.shares.commons.model.User;
import com.review.shares.sys.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @GetMapping("/demo")
    public String demo(){
        return "sys:Hello World!";
    }

    @Resource
    private IUserService userService;

    @GetMapping("/user")
    public User getUser(String username){
        return userService.getUserByUsername(username);
    }

    @GetMapping("/roles")
    public List<Role> getRoles(Integer id){
        return userService.getRolesById(id);
    }

    @GetMapping("/permissions")
    public List<Permission> getPermissions(Integer id){
        return userService.getPermissionsById(id);
    }



}
