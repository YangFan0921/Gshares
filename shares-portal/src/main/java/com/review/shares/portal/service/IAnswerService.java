package com.review.shares.portal.service;

import com.review.shares.portal.model.Answer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.review.shares.portal.vo.AnswerVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
public interface IAnswerService extends IService<Answer> {

    //新增回答
    Answer saveAnswer(AnswerVo answerVo,String username);

    //根据问题id查询回答
    List<Answer> getAnswersByQuestionId(Integer questionId);

}
