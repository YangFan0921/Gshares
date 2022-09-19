package com.review.shares.faq.controller;


import com.review.shares.commons.model.Tag;
import com.review.shares.faq.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/v2/tags")
public class TagController {

    @Autowired
    private ITagService tagService;

    @GetMapping("")
    public List<Tag> tags(){
        List<Tag> tags = tagService.getTags();
        return tags;
    }

}
