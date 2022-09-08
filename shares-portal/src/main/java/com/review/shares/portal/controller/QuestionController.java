package com.review.shares.portal.controller;

import com.github.pagehelper.PageInfo;
import com.review.shares.portal.exception.ServiceException;
import com.review.shares.portal.mapper.UserMapper;
import com.review.shares.portal.model.Question;
import com.review.shares.portal.model.User;
import com.review.shares.portal.service.IQuestionService;
import com.review.shares.portal.vo.HotQuestionVo;
import com.review.shares.portal.vo.QuestionVo;
import com.review.shares.portal.vo.RelatedQuestionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
}
