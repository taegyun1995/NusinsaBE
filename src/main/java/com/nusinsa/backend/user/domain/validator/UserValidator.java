package com.nusinsa.backend.user.domain.validator;

public interface UserValidator<T> {

    void validate(T value);

}