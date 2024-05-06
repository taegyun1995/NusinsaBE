package com.nusinsa.backend.user.application.service;

import com.nusinsa.backend.user.adapter.in.web.response.SignUpResponse;
import com.nusinsa.backend.user.application.port.in.SignUpCommand;
import com.nusinsa.backend.user.application.port.in.SignUpUseCase;
import com.nusinsa.backend.user.application.port.out.SignUpPort;
import com.nusinsa.backend.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class SignUpService implements SignUpUseCase {

    private final SignUpPort port;

    public SignUpService(SignUpPort port) {
        this.port = port;
    }

    @Override
    public SignUpResponse signUp(String userAgent, SignUpCommand command) {
        User user = User.of(userAgent, command);
        port.signUp(user);

        return null;
    }

}