package com.nusinsa.backend.advice.exception;

import lombok.Getter;

@Getter
public enum ExceptionCodeConst {

    ALREADY_EXISTS_USER(404, "ALREADY_EXISTS_USER", "이미 존재하는 유저입니다.");

    private final int status;
    private final String code;
    private final String message;

    ExceptionCodeConst(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

}