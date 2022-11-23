package com.example.mail.global.exception;

import org.springframework.http.HttpStatus;

public class DuplicateException extends HighLevelRuntimeException {

    public DuplicateException() {
    }

    @Override
    public HttpStatus statusCode() {
        return HttpStatus.BAD_REQUEST;
    }
}
