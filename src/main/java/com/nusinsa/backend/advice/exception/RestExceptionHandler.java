package com.nusinsa.backend.advice.exception;

import com.nusinsa.backend.advice.exception.custom.AlreadyExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handleNotExistsException(AlreadyExistException businessException) {
        return ResponseEntity
                .status(businessException.getExceptionCodeConst().getStatus())
                .body(new ExceptionResponse(businessException.getExceptionCodeConst()));
    }

}