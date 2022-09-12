package com.review.shares.portal.mapper;

import com.review.shares.portal.model.Answer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
@Repository
public interface AnswerMapper extends BaseMapper<Answer> {

    //按问题id查询包含所有评论的回答list
    //和xml文件对应的方法
    List<Answer> findAnswersWithCommentsByQuestionId(Integer questionId);

}
