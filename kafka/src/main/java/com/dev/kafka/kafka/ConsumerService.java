package com.dev.kafka.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final SimpMessagingTemplate template;

    public ConsumerService(SimpMessagingTemplate template){
        this.template=template;
    }

    @KafkaListener(
            topics = "dev-topic1",
    groupId="dev-consumer-group"
    )
    public void consumeMessage(String message){
        System.out.println("Consumed message: "+ message);
        template.convertAndSend("/topic/kafka-messages",message);
//        return message;
    }
}
