package com.example.mail.global.exception;

import org.springframework.http.HttpStatus;

public class InvalidateException extends HighLevelRuntimeException{

    public InvalidateException() {
    }

    @Override
    public HttpStatus statusCode() {
        return HttpStatus.BAD_REQUEST;
    }
}
