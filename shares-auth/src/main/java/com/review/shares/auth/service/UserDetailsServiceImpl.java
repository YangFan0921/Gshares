package com.review.shares.auth.service;

import com.review.shares.commons.model.Permission;
import com.review.shares.commons.model.Role;
import com.review.shares.commons.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String url = "http://sys-service/v1/auth/user?username={1}";
        User user = restTemplate.getForObject(url,User.class,username);
        if (user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        url = "http://sys-service/v1/auth/permissions?id={1}";
        //微服务可以跨平台，考虑到其他语言，返回值接受使用通用(json)类型
        //Ribbon调用返回值为List类型时，接受返回值的类型为泛型类型的数组
        Permission[] permissions = restTemplate.getForObject(url,Permission[].class,user.getId());

        url = "http://sys-service/v1/auth/roles?id={1}";
        Role[] roles = restTemplate.getForObject(url,Role[].class,user.getId());

        //实例化auth数组
        String[] auth = new String[permissions.length+ roles.length];
        int i = 0;
        for (Permission p : permissions){
            auth[i++] = p.getName();
        }
        for (Role r : roles){
            auth[i++] = r.getName();
        }

        //构建UserDetails对象
        UserDetails u = org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(auth)
                .accountLocked(user.getLocked()==1)
                .disabled(user.getEnabled()==0)
                .build();

        return u;

    }
}
