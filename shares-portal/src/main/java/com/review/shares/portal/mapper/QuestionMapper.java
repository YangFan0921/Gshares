package com.review.shares.portal.mapper;

import com.review.shares.portal.model.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
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
public interface QuestionMapper extends BaseMapper<Question> {

    @Select("select id,title,status,page_views from question where delete_status=0 order by page_views desc LIMIT 0,10")
    List<Question> getHotQuestionList();

    @Select("select count(1) from answer where quest_id=#{questId}")
    Integer countAnswer(Integer questId);

    @Select("select q.* from question q " +
            "left join user_question uq on uq.question_id = q.id " +
            "where q.user_id = #{userId} or uq.user_id=#{userId} " +
            "order by q.createtime desc ")
    List<Question> findTeacherQuestions(Integer userId);

}
