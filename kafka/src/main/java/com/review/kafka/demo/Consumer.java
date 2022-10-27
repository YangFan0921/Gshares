package com.review.kafka.demo;

import com.google.gson.Gson;
import com.review.kafka.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    //消费者即消息的接受方，应该是只要有消息就立即接受并处理

    private Gson gson = new Gson();

    //消费者接受信息的机制是监听器
    //此监听器会时刻关注指定话题名称，只要这个话题名称中有消息
    //就自动调用指定方法

    //监听器关注的话题名称
    @KafkaListener(topics = "demoTopic")
    //方法的参数为消息的内容
    //ConsumerRecord<[话题名称],[消息内容]]>
    public void receive(ConsumerRecord<String,String> record){
        //获得消息内容(发送过来的是json字符串)
        String json = record.value();
        //将json字符串转换为java对象
        Message message = gson.fromJson(json, Message.class);
        log.debug("接收到的信息：{}",message);
    }

}
