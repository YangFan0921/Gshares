package com.review.shares.portal.service;

import com.review.shares.portal.model.Question;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author review.com
 * @since 2022-08-09
 */
public interface IQuestionService extends IService<Question> {

    List<Question> getMyQuestion(String username);

}
