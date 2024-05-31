package com.nusinsa.backend.user.application.port.in.signUp;

import com.nusinsa.backend.user.adapter.in.web.response.signUp.SignUpResponse;

public interface SignUpUseCase {

    SignUpResponse signUp(final String userAgent, final SignUpCommand command);

}