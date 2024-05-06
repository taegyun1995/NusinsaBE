package com.nusinsa.backend.user.application.port.in;

import com.nusinsa.backend.user.domain.LoginId;
import com.nusinsa.backend.user.domain.Password;
import com.nusinsa.backend.user.domain.UserName;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpCommand {

    private LoginId loginId;
    private Password password;
    private UserName userName;

    public SignUpCommand(LoginId loginId, Password password, UserName userName) {
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
    }
}