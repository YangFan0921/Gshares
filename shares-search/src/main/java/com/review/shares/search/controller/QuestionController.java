package com.review.shares.search.controller;

import com.github.pagehelper.PageInfo;
import com.review.shares.search.service.IQuestionService;
import com.review.shares.search.vo.QuestionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/v3/questions")
public class QuestionController {

    @Resource
    private IQuestionService questionService;
    @PostMapping
    public PageInfo<QuestionVo> search(String key, Integer pageNum, @AuthenticationPrincipal UserDetails user){
        Integer pageSize = 8;
        PageInfo<QuestionVo> pageInfo = questionService.search(key,user.getUsername(),pageNum,pageSize);
        return pageInfo;
    }
}
