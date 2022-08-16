package com.review.shares.portal.controller;


import com.github.pagehelper.PageInfo;
import com.review.shares.portal.model.Question;
import com.review.shares.portal.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
@RequestMapping("/v1/questions")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;


    @GetMapping("/my")
    //@AuthenticationPrincipal获得当前登录用户的详情
    public PageInfo<Question> getMyQuestions(@AuthenticationPrincipal UserDetails user,Integer pageNum){
        if (pageNum == null){
            pageNum=1;
        }
        Integer pageSize = 8;
        PageInfo<Question> pageInfo = questionService.getMyQuestion(user.getUsername(),pageNum,pageSize);
        return pageInfo;
    }

}
