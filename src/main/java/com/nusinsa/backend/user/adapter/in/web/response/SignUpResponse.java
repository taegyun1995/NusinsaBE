package com.nusinsa.backend.user.adapter.in.web.response;

import com.nusinsa.backend.user.domain.LoginId;
import com.nusinsa.backend.user.domain.User;
import com.nusinsa.backend.user.domain.UserName;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SignUpResponse {

    private final LoginId loginId;
    private final UserName userName;
    private final String accessToken;

    @Builder
    public SignUpResponse(final LoginId loginId, final UserName userName, final String accessToken) {
        this.loginId = loginId;
        this.userName = userName;
        this.accessToken = accessToken;
    }

    public static SignUpResponse of(final User user) {
        return SignUpResponse.builder()
                .loginId(user.getLoginId())
                .userName(user.getUserName())
                .build();
    }

}