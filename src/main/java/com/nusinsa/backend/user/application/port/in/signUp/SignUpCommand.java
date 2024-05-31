package com.nusinsa.backend.user.application.port.in.signUp;

import com.nusinsa.backend.user.domain.LoginId;
import com.nusinsa.backend.user.domain.Password;
import com.nusinsa.backend.user.domain.UserName;

public record SignUpCommand(LoginId loginId, Password password, UserName userName) {
}