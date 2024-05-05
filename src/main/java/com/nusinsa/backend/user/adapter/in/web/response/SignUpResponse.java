package com.nusinsa.backend.user.adapter.in.web.response;

import com.nusinsa.backend.user.domain.LoginId;
import lombok.Getter;

@Getter
public class SignUpResponse {

    private final LoginId loginId;

    public SignUpResponse(LoginId loginId) {
        this.loginId = loginId;
    }

}