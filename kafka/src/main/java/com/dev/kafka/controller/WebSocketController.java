package com.dev.kafka.controller;

import com.dev.kafka.kafka.ProducerService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final ProducerService producerService;

    public WebSocketController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @MessageMapping("/send")
    @SendTo("/topic/kafka-messages")
    public String sendMessage(String message) {
        producerService.sendMessage(message);
        return message;
    }
}

