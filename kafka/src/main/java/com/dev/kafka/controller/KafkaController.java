package com.dev.kafka.controller;

import com.dev.kafka.kafka.ProducerService;
import com.dev.kafka.model.MessageModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private final ProducerService producerService;
    public KafkaController(ProducerService producerService){
        this.producerService=producerService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody MessageModel message){
        producerService.sendMessage(message.getMessage());
        return "Message sent to kafka "+ message;
    }
}
