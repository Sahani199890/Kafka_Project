package com.dev.kafka.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @KafkaListener(
            topics = "dev-topic1",
    groupId="dev-consumer-group"
    )
    public String consumeMessage(String message){
        System.out.println("Consumed message: "+ message);
        return message;
    }
}
