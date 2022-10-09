package com.review.shares.sys.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/v1/home")
public class HomeController {

    public static final GrantedAuthority STUDENT = new SimpleGrantedAuthority("ROLE_STUDENT");
    public static final GrantedAuthority TEACHER = new SimpleGrantedAuthority("ROLE_TEACHER");

    @GetMapping
    public String index(@AuthenticationPrincipal UserDetails user) {
        if (user.getAuthorities().contains(STUDENT)) {
            //等价于 response.sendRedirect("/index_student.html")
            return "/index_student.html";
        } else if (user.getAuthorities().contains(TEACHER)) {
            return "/index_teacher.html";
        }
        return "/login.html";
    }
}
