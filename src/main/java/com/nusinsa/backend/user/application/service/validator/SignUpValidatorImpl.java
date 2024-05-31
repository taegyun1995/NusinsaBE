package com.nusinsa.backend.user.application.service.validator;

import com.nusinsa.backend.user.domain.User;
import com.nusinsa.backend.user.domain.validator.LoginIdValidator;
import com.nusinsa.backend.user.domain.validator.PasswordValidator;
import com.nusinsa.backend.user.domain.validator.UserNameValidator;
import org.springframework.stereotype.Component;

@Component
public class SignUpValidatorImpl implements SignUpValidator {

    private final LoginIdValidator loginIdValidator;
    private final PasswordValidator passwordValidator;
    private final UserNameValidator userNameValidator;

    public SignUpValidatorImpl(
            LoginIdValidator loginIdValidator,
            PasswordValidator passwordValidator,
            UserNameValidator userNameValidator
    ) {
        this.loginIdValidator = loginIdValidator;
        this.passwordValidator = passwordValidator;
        this.userNameValidator = userNameValidator;
    }

    @Override
    public void validate(User user) {
        loginIdValidator.validate(user.getLoginId());
        passwordValidator.validate(user.getPassword());
        userNameValidator.validate(user.getUserName());
    }

}