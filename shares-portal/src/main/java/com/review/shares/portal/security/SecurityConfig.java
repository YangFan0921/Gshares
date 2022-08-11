package com.review.shares.portal.security;

import com.review.shares.portal.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

//标明此类为Spring的配置类
@Configuration
//启动Spring-Security框架的权限管理功能
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    //从Spring容器中获得编写好的用户名密码登录的对象
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth管理Spring-Security进行登录权限管理的核心对象
//        auth.inMemoryAuthentication()
//                .withUser("jack")
//                .password("{bcrypt}$2a$10$T72MJiqf/oASuwzXpYIhf.tXS5oJELkrnhNw/YZbIpByMTVAMbns.")
//                .authorities("add","delete");

        auth.userDetailsService(userDetailsService);





    }
}
