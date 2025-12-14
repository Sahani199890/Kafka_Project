package com.dev.kafka.model;

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

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
