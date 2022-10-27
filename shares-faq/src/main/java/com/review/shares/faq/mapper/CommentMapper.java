package com.review.shares.faq.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.review.shares.commons.model.Comment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

        @Update("update comment set content=#{content} where id=#{id}")
        Integer updateCommentContentById(@Param("content") String content, @Param("id") Integer id);

        }
