package com.review.shares.faq.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.review.shares.commons.exception.ServiceException;
import com.review.shares.commons.model.Comment;
import com.review.shares.commons.model.User;
import com.review.shares.faq.mapper.CommentMapper;
import com.review.shares.faq.service.ICommentService;
import com.review.shares.faq.vo.CommentVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {



    @Resource
    private CommentMapper commentMapper;

    @Resource
    private RibbonClient ribbonClient;


    @Transactional
    @Override
    public Comment saveComment(CommentVo commentVo, String username) {
        User user = ribbonClient.getUser(username);
        Comment comment = new Comment()
                .setUserId(user.getId())
                .setUserNickName(user.getNickname())
                .setAnswerId(commentVo.getAnswerId())
                .setContent(commentVo.getContent())
                .setCreatetime(LocalDateTime.now());
        int num = commentMapper.insert(comment);
        if (num != 1){
            throw new ServiceException("服务器忙");
        }
        return comment;
    }

    @Transactional
    @Override
    public boolean removeCommentById(Integer id,String username) {
        User user = ribbonClient.getUser(username);
        if (user.getType() == 1){
            int num = commentMapper.deleteById(id);
            return num == 1;
        }
        Comment comment = commentMapper.selectById(id);
        if (user.getId() == comment.getUserId()){
            int num = commentMapper.deleteById(id);
            return num == 1;
        }
        throw new ServiceException("您不能删除此评论！");
    }

    @Transactional
    @Override
    public Comment updateCommentById(Integer commentId,CommentVo commentVo,String username) {
        User user = ribbonClient.getUser(username);
        Comment comment = commentMapper.selectById(commentId);
        if (user.getType() == 1 || user.getId() == comment.getUserId()){
            Integer num = commentMapper.updateCommentContentById(commentVo.getContent(), commentId);
            comment.setContent(commentVo.getContent());
            if (num!=1){
                throw new ServiceException("服务器忙");
            }
            return comment;
        }
        throw new ServiceException("您不能修改此评论！");
    }


}
