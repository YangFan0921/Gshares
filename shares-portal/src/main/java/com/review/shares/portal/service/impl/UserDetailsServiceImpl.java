package com.review.shares.portal.service.impl;

import com.review.shares.portal.mapper.UserMapper;
import com.review.shares.portal.model.Permission;
import com.review.shares.portal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    //由Spring Security框架约定的登录实现的方法
    //方法的参数为用户在登录表单输入的用户名
    //返回值UserDetails为Spring Security框架提供的类型
    //其中包含了必要的用户详情信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //1.根据用户名获取用户信息
        User user = userMapper.findUserByUsername(username);
        if (user == null){
            return null;
        }
        //2.根据用户id获得用户所有权限
        List<Permission> ps = userMapper.findUserPermissionsByID(user.getId());
        //3.将用户的所有权限保存在一个数组中(框架要求保存在字符串数组中)
        String[] auth = new String[ps.size()];
        int i = 0;
        for (Permission p : ps){
            auth[i++] = p.getName();
        }
        //4.构建UserDetails对象，并对其主要属性赋值
        UserDetails u = org.springframework.security.core.userdetails.User
                        .builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .authorities(auth)
                        .accountLocked(user.getLocked()==1) //false不锁定
                        .disabled(user.getEnabled()==0) //false可用
                        .build();
        //5.返回
        return u;
    }
}
