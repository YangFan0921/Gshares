package com.review.shares.faq.controller;


import com.github.pagehelper.PageInfo;
import com.review.shares.commons.exception.ServiceException;
import com.review.shares.commons.model.Question;
import com.review.shares.faq.service.IQuestionService;
import com.review.shares.faq.vo.HotQuestionVo;
import com.review.shares.faq.vo.QuestionVo;
import com.review.shares.faq.vo.RelatedQuestionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/v2/questions")
public class QuestionController {
    @SuppressWarnings("all")
    @Autowired
    private IQuestionService questionService;

    //@AuthenticationPrincipal获得当前登录用户的详情
    @GetMapping("/my")
    public PageInfo<Question> getMyQuestions(@AuthenticationPrincipal UserDetails user, Integer pageNum) {
        if (pageNum == null) {
            pageNum = 1;
        }
        Integer pageSize = 8;
        PageInfo<Question> pageInfo = questionService.getMyQuestion(user.getUsername(), pageNum, pageSize);
        return pageInfo;
    }

    @PostMapping("")
    public String creatQuestion(@Validated QuestionVo questionVo, BindingResult result, @AuthenticationPrincipal UserDetails user) {
        log.debug("接收到了问题内容：{}", questionVo);
        if (result.hasErrors()) {
            String msg = result.getFieldError().getDefaultMessage();
            return msg;
        }
        try {
            questionService.saveQuestion(questionVo, user.getUsername());
            return "问题发布成功";
        } catch (ServiceException e) {
            log.error("发布失败", e);
            return e.getMessage();
        }
    }

    @GetMapping("/hotquestion")
    public List<HotQuestionVo> hotQuestions() {
        List<HotQuestionVo> hotQuestionList = questionService.getHotQuestionList();
        return hotQuestionList;
    }

    @GetMapping("/relatedquestion")
    public List<RelatedQuestionVo> relatedQuestions(@AuthenticationPrincipal UserDetails user){
        List<RelatedQuestionVo> relatedQuestionList = questionService.getRelatedQuestionList(user.getUsername());
        return relatedQuestionList;
    }

    //Spring-Security判断当前登录用户是否拥有权限
    @GetMapping("/teacher")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public PageInfo<Question> getTeacherQuestion(@AuthenticationPrincipal UserDetails user, Integer pageNum) {
        if (pageNum == null) {
            pageNum = 1;
        }
        Integer pageSize = 8;
        PageInfo<Question> pageInfo = questionService.getTeacherQuestions(user.getUsername(), pageNum, pageSize);
        return pageInfo;
    }

    //{id}为占位符,由SpringMVC调用
    @GetMapping("/{id}")
    public Question questionDetail(@PathVariable Integer id) {
        if (id == null) {
            throw new ServiceException("ID 不能为空！");
        }
        Question question = questionService.getQuestionById(id);
        return question;
    }

    //根据用户id查询用户的问题数
    @GetMapping("/count")
    public Integer countQuestions(Integer userId){
        Integer num = questionService.countQuestionByUserId(userId);
        return num;
    }

    //根据页码和每页条数分页查询问题集合
    @GetMapping("/page")
    public List<Question> questions(Integer pageNum,Integer pageSize){
        PageInfo<Question> pageInfo = questionService.getQuestions(pageNum,pageSize);
        return pageInfo.getList();
    }
    @GetMapping("/page/count")
    public Integer pageCount(Integer pageSize){
        //获得当前question的总条数
        Integer rows = questionService.count();
        //根据rows是否能够被pageSize整除来计算总页数
        return rows%pageSize==0? rows/pageSize:rows/pageSize+1;
//        return (rows+pageSize-1)/pageSize;
    }

}
