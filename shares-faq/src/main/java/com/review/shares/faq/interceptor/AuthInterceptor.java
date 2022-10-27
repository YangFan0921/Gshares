package com.review.shares.faq.interceptor;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求中获得参数
        String token = request.getParameter("accessToken");
        //通过授权服务器的解析JWT的方法获得用户详情对象
        String url = "http://auth-service/oauth/check_token?token={1}";
        Map<String,Object> map = restTemplate.getForObject(url, Map.class,token);
        List<String> list = (List<String>) map.get("authorities");
        //UserDetails需要的是String[]
        String[] auth = list.toArray(new String[0]);
        UserDetails userDetails = User.builder()
                .username(map.get("user_name").toString())
                .password("")
                .authorities(auth)
                .build();
        //将用户详情保存到Spring-Security中
        //目标: 控制器方法参数@AuthenticationPrincipal可以获得用户详情
        //参数: userDetails userDetails.getPassword() GrantedAuthority[]
        PreAuthenticatedAuthenticationToken authenticationToken = new PreAuthenticatedAuthenticationToken(
                userDetails,userDetails.getPassword(), AuthorityUtils.createAuthorityList(auth)
        );
        //关联本次解析的用户详情和当前请求 才能在控制器中获得用户详情
        authenticationToken.setDetails(new WebAuthenticationDetails(request));
        //将authenticationToken赋值到Spring-Security容器
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return true;
    }
}
