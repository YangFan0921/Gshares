package com.review.shares.search.kafka;

import com.google.gson.Gson;
import com.review.shares.commons.Topic;
import com.review.shares.search.service.IQuestionService;
import com.review.shares.search.vo.QuestionVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class KafkaConsumer {

    private Gson gson = new Gson();

    @Resource
    private IQuestionService questionService;

    @KafkaListener(topics = Topic.QUESTION)
    public void receive(ConsumerRecord<String,String> record){
        String json = record.value();
        QuestionVo questionVo = gson.fromJson(json,QuestionVo.class);
        log.debug("从kafka收到了消息：{}",questionVo);
        //将接受到的问题对象新增到ES
        questionService.saveQuestion(questionVo);
    }


}
