package com.nusinsa.backend.user.application.service;

import com.nusinsa.backend.user.adapter.in.web.response.SignUpResponse;
import com.nusinsa.backend.user.application.port.in.SignUpCommand;
import com.nusinsa.backend.user.application.port.in.SignUpUseCase;
import com.nusinsa.backend.user.application.port.out.SignUpPort;
import com.nusinsa.backend.user.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignUpService implements SignUpUseCase {

    private final SignUpPort port;

    public SignUpService(SignUpPort port) {
        this.port = port;
    }

    @Transactional
    @Override
    public SignUpResponse signUp(final String userAgent, final SignUpCommand command) {
        User user = User.of(userAgent, command);
        port.signUp(user);

        return SignUpResponse.of(user);
    }

}