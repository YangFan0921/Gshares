package com.review.shares.sys;

import com.review.shares.commons.model.User;
import com.review.shares.sys.mapper.UserMapper;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SharesSysApplicationTests {



    @Test
    void contextLoads() {

    }

    @Resource
    UserMapper userMapper;

    @Test
    public void run(){
        User user = userMapper.findUserByUsername("st2");
        System.out.println(user);
    }



}
