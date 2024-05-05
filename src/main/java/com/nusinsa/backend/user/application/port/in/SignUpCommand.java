package com.nusinsa.backend.user.application.port.in;

import com.nusinsa.backend.user.domain.LoginId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpCommand {

    private LoginId loginId;

    public SignUpCommand(LoginId loginId) {
        this.loginId = loginId;
    }

}