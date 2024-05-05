package com.nusinsa.backend.user.application.service;

import com.nusinsa.backend.user.adapter.in.web.response.SignUpResponse;
import com.nusinsa.backend.user.application.port.in.SignUpCommand;
import com.nusinsa.backend.user.application.port.in.SignUpUseCase;
import org.springframework.stereotype.Service;

@Service
public class SignUpService implements SignUpUseCase {

    @Override
    public SignUpResponse signUp(SignUpCommand command) {
        return null;
    }

}