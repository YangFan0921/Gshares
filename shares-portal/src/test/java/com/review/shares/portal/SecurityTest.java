package com.review.shares.portal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class SecurityTest {

    //加密
    @Test
    void security(){
        //密码加密类型的接口
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        //加密12356并返回
        String pwd = encoder.encode("123456");
        System.out.println(pwd);
        //$2a$10$T72MJiqf/oASuwzXpYIhf.tXS5oJELkrnhNw/YZbIpByMTVAMbns.
    }

    //验证
    @Test
    void match(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean b = encoder.matches("123456","$2a$10$T72MJiqf/oASuwzXpYIhf.tXS5oJELkrnhNw/YZbIpByMTVAMbns.");
        System.out.println(b);

    }
}
