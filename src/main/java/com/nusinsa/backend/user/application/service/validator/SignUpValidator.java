package com.nusinsa.backend.user.application.service.validator;

import com.nusinsa.backend.user.domain.User;

public interface SignUpValidator {

    void validate(final User user);

}