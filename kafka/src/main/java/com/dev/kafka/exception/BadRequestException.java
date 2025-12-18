package com.dev.kafka.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message){
        super(message);
    }
    public static BadRequestException exception(String message){
        return new BadRequestException(message);
    }
}
