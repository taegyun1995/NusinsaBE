package com.nusinsa.backend.user.application.service.signUp;

import com.nusinsa.backend.advice.exception.ExceptionCodeConst;
import com.nusinsa.backend.advice.exception.custom.AlreadyExistException;
import com.nusinsa.backend.common.UseCase;
import com.nusinsa.backend.user.adapter.in.web.response.signUp.SignUpResponse;
import com.nusinsa.backend.user.application.port.in.common.UserConvertor;
import com.nusinsa.backend.user.application.port.in.signUp.SignUpCommand;
import com.nusinsa.backend.user.application.port.in.signUp.SignUpUseCase;
import com.nusinsa.backend.user.application.port.out.signUp.SignUpPort;
import com.nusinsa.backend.user.application.service.validator.SignUpValidator;
import com.nusinsa.backend.user.domain.User;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class SignUpService implements SignUpUseCase {

    private final SignUpPort signUpPort;
    private final SignUpValidator signUpValidator;

    public SignUpService(SignUpPort signUpPort, SignUpValidator signUpValidator) {
        this.signUpPort = signUpPort;
        this.signUpValidator = signUpValidator;
    }

    @Override
    @Transactional
    public SignUpResponse signUp(final String userAgent, final SignUpCommand command) {
        User user = UserConvertor.toUserDomain(userAgent, command);

        signUpValidator.validate(user);
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