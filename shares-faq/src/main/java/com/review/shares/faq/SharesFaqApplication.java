package com.review.shares.faq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.review.shares.faq.mapper")
public class SharesFaqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharesFaqApplication.class, args);
    }

}
