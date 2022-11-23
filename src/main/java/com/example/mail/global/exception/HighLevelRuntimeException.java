package com.example.mail.global.exception;

import org.springframework.http.HttpStatus;

public abstract class HighLevelRuntimeException extends RuntimeException{

    public HighLevelRuntimeException() {
    }

    public abstract HttpStatus statusCode();
}
