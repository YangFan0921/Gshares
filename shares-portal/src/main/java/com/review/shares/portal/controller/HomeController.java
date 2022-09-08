package com.review.shares.portal.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HomeController.class);
    //</editor-fold>
    public static final GrantedAuthority STUDENT = new SimpleGrantedAuthority("ROLE_STUDENT");
    public static final GrantedAuthority TEACHER = new SimpleGrantedAuthority("ROLE_TEACHER");

    @GetMapping({"/", "/index.html"})
    public String index(@AuthenticationPrincipal UserDetails user) {
        if (user.getAuthorities().contains(STUDENT)) {
            //等价于 response.sendRedirect("/index_student.html")
            return "redirect:/index_student.html";
        } else if (user.getAuthorities().contains(TEACHER)) {
            return "redirect:/index_teacher.html";
        }
        return "redirect:/login.html";
    }
}
