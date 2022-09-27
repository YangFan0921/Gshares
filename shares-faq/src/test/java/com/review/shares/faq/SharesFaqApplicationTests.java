package com.review.shares.faq;

import com.review.shares.commons.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SharesFaqApplicationTests {

    //redis对象
    //自动被赋值，由依赖来实例化
    @Resource
    RedisTemplate<String,String> redisTemplate;

    @Test
    void contextLoads() {
        //向redis中保存信息(键值对类型)
        redisTemplate.opsForValue().set("myname","阿帆");
        System.out.println(redisTemplate.opsForValue().get("myname"));
    }


    @Resource
    RestTemplate restTemplate;
    @Test
    void run(){
        //要调用的控制器的路径
        String url = "http://sys-service/v1/auth/demo";
        // 第二个参数(String.class) 根据上面方法的返回值而定
        String message = restTemplate.getForObject(url,String.class);
        System.out.println(message);
    }

    @Test
    void test(){
        //要调用的控制器的路径
        String url = "http://sys-service/v1/auth/user?username={1}";
        // 第二个参数(String.class) 根据上面方法的返回值而定
        User user = restTemplate.getForObject(url,User.class,"st2");
        System.out.println(user);
    }

}
