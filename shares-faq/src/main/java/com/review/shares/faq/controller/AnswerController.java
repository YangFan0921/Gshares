package com.review.shares.faq.controller;


import com.review.shares.commons.exception.ServiceException;
import com.review.shares.commons.model.Answer;
import com.review.shares.faq.service.IAnswerService;
import com.review.shares.faq.vo.AnswerVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
@RequestMapping("/v2/answers")
public class AnswerController {
    @Resource
    private IAnswerService answerService;

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public Answer addAnswer(@AuthenticationPrincipal UserDetails user, @Validated AnswerVo answerVo, BindingResult result) {
        log.debug("收到信息：{}", answerVo);
        if (result.hasErrors()) {
            String msg = result.getFieldError().getDefaultMessage();
            throw new ServiceException(msg);
        }
        Answer answer = answerService.saveAnswer(answerVo, user.getUsername());
        return answer;
    }

    @GetMapping("/question/{id}")
    public List<Answer> getAnswersByQuestionId(@PathVariable Integer id){
        if (id == null){
            throw new ServiceException("问题id不能为空");
        }
        List<Answer> answers = answerService.getAnswersByQuestionId(id);
        return answers;
    }

    @GetMapping("/{answerId}/solved")
    public String solved(@PathVariable Integer answerId){
        boolean isAccept = answerService.accept(answerId);
        if (isAccept){
            return "采纳成功";
        }else {
            return "采纳失败,检查回答存在并且没有被采纳过";
        }
    }

}
