package com.review.shares.portal.controller;


import com.github.pagehelper.PageInfo;
import com.review.shares.portal.exception.ServiceException;
import com.review.shares.portal.model.Question;
import com.review.shares.portal.service.IQuestionService;
import com.review.shares.portal.vo.HotQuestionVo;
import com.review.shares.portal.vo.QuestionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.xml.soap.Detail;
import java.util.ArrayList;
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
@Slf4j
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

    @PostMapping("")
    public String creatQuestion(@Validated QuestionVo questionVo, BindingResult result,@AuthenticationPrincipal UserDetails user){
        log.debug("接收到了问题内容：{}",questionVo);
        if (result.hasErrors()){
            String msg = result.getFieldError().getDefaultMessage();
            return msg;
        }
        try {
            questionService.saveQuestion(questionVo,user.getUsername());
            return "问题发布成功";
        }catch (ServiceException e){
            log.error("发布失败",e);
            return e.getMessage();
        }
    }

    @GetMapping("/hotquestion")
    public List<HotQuestionVo> hotQuestions(){
        List<HotQuestionVo> hotQuestionList = questionService.getHotQuestionList();
        return hotQuestionList;
    }



}
