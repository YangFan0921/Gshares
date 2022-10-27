package com.review.shares.faq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.review.shares.faq.mapper")
@EnableKafka
public class SharesFaqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharesFaqApplication.class, args);
    }

    //将Ribbon的执行对象保存到Spring容器中
    @Bean
    //使Ribbon调用支持负载均衡
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
