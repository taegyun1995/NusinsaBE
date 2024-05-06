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

    @Builder
    public SignUpResponse(LoginId loginId, UserName userName) {
        this.loginId = loginId;
        this.userName = userName;
    }

    public static SignUpResponse of(User user) {
        return SignUpResponse.builder()
                .loginId(user.getLoginId())
                .userName(user.getUserName())
                .build();
    }

}