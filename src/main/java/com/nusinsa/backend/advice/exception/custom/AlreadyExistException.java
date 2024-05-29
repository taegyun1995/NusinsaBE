package com.nusinsa.backend.advice.exception.custom;

import com.nusinsa.backend.advice.exception.BusinessException;
import com.nusinsa.backend.advice.exception.ExceptionCodeConst;

public class AlreadyExistException extends BusinessException {

    public AlreadyExistException(ExceptionCodeConst exceptionCodeConst) {
        super(exceptionCodeConst);
    }

}