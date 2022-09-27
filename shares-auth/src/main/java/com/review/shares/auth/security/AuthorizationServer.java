package com.review.shares.auth.security;


import com.review.shares.auth.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

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

    //配置令牌生成


    //配置客户端详情(规定客户端权限)

    //认证成功的安全策略设置(登录成功后允许在资源服务器中做的事情)


}
