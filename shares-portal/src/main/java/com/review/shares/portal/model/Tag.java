package com.review.shares.portal.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Tag {
    private Integer id;
    private String name;
    private String createby;
    private String createtime;

    public void record(){
        log.info("Lombok的@Slf4j的注解日志信息");
    }
}
