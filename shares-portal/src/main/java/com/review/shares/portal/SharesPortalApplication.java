package com.review.shares.portal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan是MyBatis的注解
//指定一个包中所有的接口是MyBatis框架的mapper接口
//这样此包中所有与接口不需要每个都使用@Mapper标记
@MapperScan("com.review.shares.portal.mapper")
public class SharesPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharesPortalApplication.class, args);
    }

}
