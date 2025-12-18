package com.dev.kafka.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageModel {
    private String messageId;
    private String from;
    private String to;
    private String message;

    public MessageModel(String messageId, String from, String to, String message) {
        this.messageId = messageId;
        this.from = from;
        this.to = to;
        this.message = message;
    }

    public MessageModel() {
    }

}
