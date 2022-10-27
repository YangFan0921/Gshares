package com.review.shares.auth.security;


import com.review.shares.auth.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;

/**
 *
 * 授权服务器核心配置
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    //配置授权服务器端点信息
    //用户访问/oauth/token时的操作

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //配置SpringSecurity中获得的认证管理器
        endpoints.authenticationManager(authenticationManager)
                //配置获得用户详情的方法
                .userDetailsService(userDetailsService)
                //为了安全,限制登录提交的方式只能是POST
                .allowedTokenEndpointRequestMethods(HttpMethod.POST)
                //配置令牌生成器
                .tokenServices(tokenService());
    }


    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private JwtAccessTokenConverter accessTokenConverter;
    //配置令牌生成
    @Bean
    public AuthorizationServerTokenServices tokenService(){
        DefaultTokenServices services = new DefaultTokenServices();
        //支持令牌刷新策略
        services.setSupportRefreshToken(true);
        //设置令牌生成策略
        services.setTokenStore(tokenStore);
        //设置令牌增强对象(JWT令牌固定配置)
        TokenEnhancerChain chain = new TokenEnhancerChain();
        //此对象可以添加很多令牌转换器
        chain.setTokenEnhancers(Arrays.asList(accessTokenConverter));
        //设置chain到当前生成令牌的配置对象
        services.setTokenEnhancer(chain);
        //设置令牌有效期 单位秒(1小时)
        services.setAccessTokenValiditySeconds(3600);
        //设置令牌刷新最大时间(1小时)
        services.setRefreshTokenValiditySeconds(3600);
        //设置客户端详情
        services.setClientDetailsService(clientDetailsService);
        return services;
    }


    @Autowired
    private PasswordEncoder passwordEncoder;
    //配置客户端详情(规定客户端权限)
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                //定义客户端id
                .withClient("shares")
                //此客户端密钥
                .secret(passwordEncoder.encode("921"))
                //授予客户端权限,all只是名字而已,类似ROLE_STUDENT
                .scopes("all")
                //当前客户端支持的Oauth2操作
                //password 为Oauth2支持用户名密码登录
                //refresh_token 为Oauth2支持刷新令牌
                .authorizedGrantTypes("password","refresh_token");
    }

    //认证成功的安全策略设置(登录成功后允许在资源服务器中做的事情)
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许任何认访问/oauth/token_key端点
        security.tokenKeyAccess("permitAll()")
                //允许任何人访问/oauth/check_token端点
                .checkTokenAccess("permitAll()")
                //允许客户端进行表单权限认证(登录成功赋予令牌)
                .allowFormAuthenticationForClients();

    }
}
