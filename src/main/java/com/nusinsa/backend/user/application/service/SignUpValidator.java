package com.nusinsa.backend.user.application.service;

import com.nusinsa.backend.user.domain.User;

public interface SignUpValidator {

    void validate(final User user);

}