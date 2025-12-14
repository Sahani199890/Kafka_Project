package com.dev.kafka.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final String TOPICNAME="dev-topic1";
    private final KafkaTemplate<String,String> kafkaTemplate;
    public ProducerService(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }
    public void sendMessage(String message){
        kafkaTemplate.send(TOPICNAME,message);
    }
}
