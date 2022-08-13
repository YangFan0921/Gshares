package com.review.shares.portal.security;

import com.review.shares.portal.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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

    //放行
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()  //设置请求限制
                .antMatchers(     //指定受影响资源
                        "/index_student.html",
                        "/img/**",   //*当前目录  **当前所有目录
                        "/js/*",
                        "/css/*",
                        "/bower_components/**",
                        "/login.html",
                        "/register.html",
                        "/register"
                ).permitAll()       //全部允许
                .anyRequest()
                //其他请求
                .authenticated()    //登录才能访问
                .and()
                .formLogin()       //使用表单登录
                .loginPage("/login.html")
                .loginProcessingUrl("/login")  //登录提交路径 与前端页面的action一直
                .failureUrl("/login.html?error") //登录失败跳转的页面
                .defaultSuccessUrl("/index_student.html") //登录成功跳转的页面
                .and()
                .logout()
                .logoutUrl("/logout") //登出的路径
                .logoutSuccessUrl("/login.html?logout")
                .and()
                .csrf().disable();   //关闭防跨域攻击
    }
}
