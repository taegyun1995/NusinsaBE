package com.nusinsa.backend.user.adapter.in.web.response.signUp;

import com.nusinsa.backend.user.domain.LoginId;
import com.nusinsa.backend.user.domain.User;
import com.nusinsa.backend.user.domain.UserName;

public record SignUpResponse(LoginId loginId, UserName userName) {

    public SignUpResponse {
    }

    public static SignUpResponse of(final User user) {
        return new SignUpResponse(user.getLoginId(), user.getUserName());
    }

}