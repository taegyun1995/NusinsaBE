package com.nusinsa.backend.advice.exception;

public record ExceptionResponse(int status, String code, String message) {

    public ExceptionResponse(ExceptionCodeConst exceptionCodeConst) {
        this(
                exceptionCodeConst.getStatus(),
                exceptionCodeConst.getCode(),
                exceptionCodeConst.getMessage()
        );
    }

}