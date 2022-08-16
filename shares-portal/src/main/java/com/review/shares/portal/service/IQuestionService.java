package com.review.shares.portal.service;

import com.github.pagehelper.PageInfo;
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

    // 查询当前学生的问题列表（包含page等信息）
    PageInfo<Question> getMyQuestion(String username,Integer pageNum,Integer pageSize);

}
