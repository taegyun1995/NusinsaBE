package com.nusinsa.backend.user.domain;

import com.nusinsa.backend.user.application.port.in.SignUpCommand;
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

    public static User of(final String userAgent, final SignUpCommand command) {
        return User.builder()
                .loginId(command.loginId())
                .password(command.password())
                .userName(command.userName())
                .userAgent(userAgent)
                .build();
    }

}