package com.review.shares.portal.controller;


import com.review.shares.portal.model.Tag;
import com.review.shares.portal.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    private ITagService tagService;

    @GetMapping("")
    public List<Tag> tags(){
        List<Tag> tags = tagService.getTags();
        return tags;
    }

}
