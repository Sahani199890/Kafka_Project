package com.dev.kafka.exception;

import com.dev.kafka.entity.UsersEntity;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message){
        super(message);
    }
    public static UsersEntity exception(String message){
        return new BadRequestException(message);
    }
}
