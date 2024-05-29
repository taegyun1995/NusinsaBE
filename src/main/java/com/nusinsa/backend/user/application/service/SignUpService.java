package com.nusinsa.backend.user.application.service;

import com.nusinsa.backend.advice.exception.ExceptionCodeConst;
import com.nusinsa.backend.advice.exception.custom.AlreadyExistException;
import com.nusinsa.backend.common.UseCase;
import com.nusinsa.backend.user.adapter.in.web.response.SignUpResponse;
import com.nusinsa.backend.user.application.port.in.*;
import com.nusinsa.backend.user.application.port.out.SignUpPort;
import com.nusinsa.backend.user.domain.User;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class SignUpService implements SignUpUseCase {

    private final SignUpPort signUpPort;
    private final UserValidator userValidator;

    public SignUpService(SignUpPort signUpPort, UserValidator userValidator) {
        this.signUpPort = signUpPort;
        this.userValidator = userValidator;
    }

    @Override
    @Transactional
    public SignUpResponse signUp(final String userAgent, final SignUpCommand command) {
        User user = UserConvertor.toDomainUser(userAgent, command);

        userValidator.validate(user);
        alreadyExistsValidateByLoginId(user);

        signUpPort.signUp(user);

        return SignUpResponse.of(user);
    }

    private void alreadyExistsValidateByLoginId(User user) {
        if (signUpPort.existsByLoginId(user.getLoginId())) {
            throw new AlreadyExistException(ExceptionCodeConst.ALREADY_EXISTS_USER);
        }
    }

}