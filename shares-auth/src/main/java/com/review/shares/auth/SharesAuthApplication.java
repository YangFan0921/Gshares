package com.review.shares.auth;

import com.review.shares.auth.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class SharesAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharesAuthApplication.class, args);
    }


    //Ribbon
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public FilterRegistrationBean registrationBean(){
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>();
        bean.addUrlPatterns("/*"); //所有路径过滤
        bean.setFilter(new CorsFilter()); //实例化过滤器对象
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE); //过滤器优先级(最高优先级)
        return bean;

    }

}
