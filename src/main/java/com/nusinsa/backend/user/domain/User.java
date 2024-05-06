package com.nusinsa.backend.user.domain;

import com.nusinsa.backend.user.application.port.in.SignUpCommand;
import lombok.Getter;

@Getter
public class User {

    private final LoginId loginId;
    private final Password password;
    private final UserName userName;
    private final String userAgent;

    public User(LoginId loginId, Password password, UserName userName, String userAgent) {
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.userAgent = userAgent;
    }

    public static User of(String userAgent, SignUpCommand command) {
        return new User(
                command.getLoginId(),
                command.getPassword(),
                command.getUserName(),
                userAgent
        );
    }

}