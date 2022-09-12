package com.review.shares.portal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.review.shares.portal.exception.ServiceException;
import com.review.shares.portal.mapper.UserMapper;
import com.review.shares.portal.model.Comment;
import com.review.shares.portal.mapper.CommentMapper;
import com.review.shares.portal.model.User;
import com.review.shares.portal.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.review.shares.portal.vo.CommentVo;
import org.springframework.security.web.PortResolverImpl;
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
    private UserMapper userMapper;
    @Resource
    private CommentMapper commentMapper;


    @Transactional
    @Override
    public Comment saveComment(CommentVo commentVo, String username) {
        User user = userMapper.findUserByUsername(username);
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
}
