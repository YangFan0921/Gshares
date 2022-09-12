package com.review.shares.portal.controller;


import com.review.shares.portal.exception.ServiceException;
import com.review.shares.portal.model.Comment;
import com.review.shares.portal.service.ICommentService;
import com.review.shares.portal.vo.CommentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@Slf4j
@RestController
@RequestMapping("/v1/comments")
public class CommentController {

    @Resource
    private ICommentService commentService;

    @PostMapping("")
    public Comment postComment(@Validated CommentVo commentVo, BindingResult result, @AuthenticationPrincipal UserDetails user){
        log.debug("接受到评论信息：{}",commentVo);
        if (result.hasErrors()){
            String msg = result.getFieldError().getDefaultMessage();
            throw new ServiceException(msg);
        }
        Comment comment = commentService.saveComment(commentVo,user.getUsername());
        return comment;
    }
}
