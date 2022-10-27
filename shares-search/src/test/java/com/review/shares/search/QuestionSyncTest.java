package com.review.shares.search;

import com.github.pagehelper.PageInfo;
import com.review.shares.search.repository.QuestionRepository;
import com.review.shares.search.service.IQuestionService;
import com.review.shares.search.vo.QuestionVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

@SpringBootTest
public class QuestionSyncTest {

    @Resource
    IQuestionService questionService;
    @Test
    void run(){
        questionService.sync();
    }

    @Resource
    QuestionRepository questionRepository;
    //查询所有ES中的数据
    @Test
    void showAll(){
        Iterable<QuestionVo> qs = questionRepository.findAll();
        for (QuestionVo questionVo : qs){
            System.out.println(questionVo);
        }
    }

    //测试模糊查询
    @Test
    void query(){
        Page<QuestionVo> page = questionRepository.queryAllByParams("方法问题","方法问题",11, PageRequest.of(0,10));
        for (QuestionVo questionVo : page){
            System.out.println(questionVo);
        }
    }

    @Test
    void searchTest(){
        PageInfo<QuestionVo> qs = questionService.search("java","st2",1,8);
        for (QuestionVo questionVo : qs.getList()){
            System.out.println(questionVo);
        }
    }

}
