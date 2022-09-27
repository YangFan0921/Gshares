package com.review.shares.auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
public class TokenConfig {

    //SpringBoot生成令牌需要一个令牌生成器对象
    //Oauth2使用这个令牌生成器生成令牌
    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }


}
