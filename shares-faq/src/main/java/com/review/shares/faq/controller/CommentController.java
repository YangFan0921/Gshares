package com.review.shares.faq.controller;


import com.review.shares.commons.exception.ServiceException;
import com.review.shares.commons.model.Comment;
import com.review.shares.faq.service.ICommentService;
import com.review.shares.faq.vo.CommentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/v2/comments")
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

    @GetMapping("/{id}/delete")
    public String removeCommentById(@PathVariable Integer id, @AuthenticationPrincipal UserDetails user){
        boolean isDelete = commentService.removeCommentById(id,user.getUsername());
        if (isDelete){
            return "删除成功";
        }else {
            return "此评论已被删除";
        }
    }

    @PostMapping("/{id}/update")
    public Comment updateCommentById(@PathVariable Integer id,@Validated CommentVo commentVo,@AuthenticationPrincipal UserDetails user,BindingResult result){
        log.debug("修改内容：{}",commentVo);
        if (result.hasErrors()){
            String msg = result.getFieldError().getDefaultMessage();
            throw new ServiceException(msg);
        }
        Comment comment = commentService.updateCommentById(id,commentVo,user.getUsername());
        return comment;
    }


}
