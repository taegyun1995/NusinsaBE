package com.nusinsa.backend.user.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

    private final LoginId loginId;
    private final Password password;
    private final UserName userName;
    private final String userAgent;

    @Builder
    public User(final LoginId loginId, final Password password, final UserName userName, final String userAgent) {
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.userAgent = userAgent;
    }

}