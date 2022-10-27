package com.review.shares.faq.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.review.shares.commons.model.Answer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
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

    //采纳答案
    @Update("update answer set accept_status=#{acceptStatus} where id=#{answerId}")
    Integer updateAcceptStatus(@Param("acceptStatus") Integer acceptStatus, @Param("answerId") Integer answerId);

}
