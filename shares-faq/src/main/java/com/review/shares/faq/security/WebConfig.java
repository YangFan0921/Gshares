package com.review.shares.faq.security;

import com.review.shares.faq.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
    @Autowired
    private AuthInterceptor authInterceptor;

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/v2/questions",
                "/v2/questions/my",
                "/v2/questions/teacher",
                "/v2/questions/relatedquestion",
                "/v2/answers",
                "/v2/answers/*/solved",
                "/v2/comments",
                "/v2/comments/*/delete",
                "/v2/comments/*/update"
        );
    }
}
