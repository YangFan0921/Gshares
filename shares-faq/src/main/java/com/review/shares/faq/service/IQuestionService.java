package com.review.shares.faq.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.review.shares.commons.model.Question;
import com.review.shares.faq.vo.HotQuestionVo;
import com.review.shares.faq.vo.QuestionVo;
import com.review.shares.faq.vo.RelatedQuestionVo;

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
    PageInfo<Question> getMyQuestion(String username, Integer pageNum, Integer pageSize);

    //新增问题
    void saveQuestion(QuestionVo questionVo, String username);

    //根据用户id查询当前用户问题数
    Integer countQuestionByUserId(Integer userId);

    //根据用户id查询当前用户的收藏数
    //Integer collectQuestionByUserId(Integer userId);

    //获取热点问题
    List<HotQuestionVo> getHotQuestionList();

    //获取相关提问
    List<RelatedQuestionVo> getRelatedQuestionList(String username);

    //查询登录老师的任务列表
    PageInfo<Question> getTeacherQuestions(String username,Integer pageNum,Integer pageSize);

    //根据id获取问题详情
    Question getQuestionById(Integer id);

    //用于和ES数据库同步数据
    PageInfo<Question> getQuestions(Integer pageNum,Integer pageSize);




}
