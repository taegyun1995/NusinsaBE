package com.nusinsa.backend.user.adapter.in.web.response;

import com.nusinsa.backend.user.domain.LoginId;
import com.nusinsa.backend.user.domain.User;
import com.nusinsa.backend.user.domain.UserName;
import lombok.Builder;

public record SignUpResponse(LoginId loginId, UserName userName, String accessToken) {

    @Builder
    public SignUpResponse {
    }

    public static SignUpResponse of(final User user) {
        return SignUpResponse.builder()
                .loginId(user.getLoginId())
                .userName(user.getUserName())
                .build();
    }

}