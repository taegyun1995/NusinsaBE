package com.nusinsa.backend.user.application.port.in;

import com.nusinsa.backend.user.adapter.in.web.response.SignUpResponse;

public interface SignUpUseCase {

    SignUpResponse signUp(final String userAgent, final SignUpCommand command);

}