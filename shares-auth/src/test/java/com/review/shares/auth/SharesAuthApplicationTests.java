package com.review.shares.auth;

import com.review.shares.auth.service.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;

@SpringBootTest
class SharesAuthApplicationTests {

    @Resource
    private UserDetailsServiceImpl userDetailsService;

    @Test
    void contextLoads() {
        UserDetails u = userDetailsService.loadUserByUsername("st2");
        System.out.println(u);

    }

}
