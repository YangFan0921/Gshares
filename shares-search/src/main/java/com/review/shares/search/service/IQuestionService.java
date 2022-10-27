package com.review.shares.search.service;

import com.github.pagehelper.PageInfo;
import com.review.shares.search.vo.QuestionVo;

public interface IQuestionService {

    //同步数据库中question表和ES中数据的方法
    public void sync();

    //返回按关键字模糊查询ES的分页结果
    PageInfo<QuestionVo> search(String key,String username,Integer pageNum,Integer pageSize);

    //新增一个问题对象到ES
    void saveQuestion(QuestionVo questionVo);

}
