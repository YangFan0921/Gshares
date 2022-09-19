package com.review.shares.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.review.shares.sys.mapper")
public class SharesSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharesSysApplication.class, args);
    }

}
