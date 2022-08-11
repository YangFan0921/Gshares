package com.review.shares.portal.controller;


import com.review.shares.portal.model.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@RestController
//@RequestMapping注解写在控制器类上
//当前类所有请求都需要使用/v1/tags做前缀
@RequestMapping("/v1/tags")
public class TagController {

    @GetMapping("/hello")
    public String welcome(){
        return "Hello World!";
    }

    @GetMapping("/get")
    //访问需要权限
    @PreAuthorize("hasAuthority('add')")
    public Tag getTag(){
        Tag tag = new Tag();
        tag.setName("乾坤大挪移");
        return tag;
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('delete')")
    public Tag getList(){
        Tag tag = new Tag();
        tag.setName("降龙十八掌");
        return tag;
    }

}
