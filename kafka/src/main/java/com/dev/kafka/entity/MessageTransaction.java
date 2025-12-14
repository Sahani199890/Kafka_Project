//package com.dev.kafka.entity;
//
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "message_transaction")
//public class MessageTransaction {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long messageId;
//    private String to;
//    private String from;
//    private String message;
//    private Date date;
//
//    public MessageTransaction() {
//    }
//
//    public MessageTransaction(Long messageId, String to, String from, String message, Date date) {
//        this.messageId = messageId;
//        this.to = to;
//        this.from = from;
//        this.message = message;
//        this.date = date;
//    }
//
//    public Long getMessageId() {
//        return messageId;
//    }
//
//    public void setMessageId(Long messageId) {
//        this.messageId = messageId;
//    }
//
//    public String getTo() {
//        return to;
//    }
//
//    public void setTo(String to) {
//        this.to = to;
//    }
//
//    public String getFrom() {
//        return from;
//    }
//
//    public void setFrom(String from) {
//        this.from = from;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//}
