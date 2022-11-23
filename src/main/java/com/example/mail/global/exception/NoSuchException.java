package com.example.mail.global.exception;

import org.springframework.http.HttpStatus;

public class NoSuchException extends HighLevelRuntimeException{

    public NoSuchException() {
    }

    @Override
    public HttpStatus statusCode() {
        return HttpStatus.BAD_REQUEST;
    }
}
