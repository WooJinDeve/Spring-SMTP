package com.example.mail.global;

import com.example.mail.global.exception.HighLevelRuntimeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(HighLevelRuntimeException.class)
    public ResponseEntity EmailSenderException(HighLevelRuntimeException e){
        return ResponseEntity.badRequest().build();
    }
}
