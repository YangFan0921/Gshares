package com.review.shares.faq.kafka;

import com.google.gson.Gson;
import com.review.shares.commons.Topic;
import com.review.shares.commons.model.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class KafkaProducer {
    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;

    private Gson gson = new Gson();

    //将问题对象发送到kafka
    public void sendQuestion(Question question){
        String json = gson.toJson(question);
        kafkaTemplate.send(Topic.QUESTION,json);
        log.debug("发送了消息到kafka：{}",json);
    }
}
