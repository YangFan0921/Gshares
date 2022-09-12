package com.review.shares.portal;

import com.review.shares.portal.mapper.AnswerMapper;
import com.review.shares.portal.model.Answer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class AnswerTest {

    @Resource
    AnswerMapper answerMapper;

    @Test
    void run(){
        List<Answer> answers = answerMapper.findAnswersWithCommentsByQuestionId(15);
        for (Answer answer : answers) {
            System.out.println(answer);
        }
    }

}
