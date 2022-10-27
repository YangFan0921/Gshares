package com.review.shares.faq.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.review.shares.commons.model.Comment;
import com.review.shares.faq.vo.CommentVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
public interface ICommentService extends IService<Comment> {

    //添加评论
    Comment saveComment(CommentVo commentVo, String username);

    //删除评论
    boolean removeCommentById(Integer id,String username);

    //修改评论
    Comment updateCommentById(Integer commentId,CommentVo commentVo,String username);


}
