package com.review.shares.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SharesResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharesResourceApplication.class, args);
    }

}
