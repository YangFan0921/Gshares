package com.review.shares.portal.service;

import com.github.pagehelper.PageInfo;
import com.review.shares.portal.model.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.review.shares.portal.vo.HotQuestionVo;
import com.review.shares.portal.vo.QuestionVo;

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

    //新增问题
    void saveQuestion(QuestionVo questionVo,String username);

    //根据用户id查询当前用户问题数
    Integer countQuestionByUserId(Integer userId);

    //根据用户id查询当前用户的收藏数
    Integer collectQuestionByUserId(Integer userId);

    //获取热点问题
    List<HotQuestionVo> getHotQuestionList();

    //查询登录老师的任务列表
    PageInfo<Question> getTeacherQuestions(String username,Integer pageNum,Integer pageSize);





}
