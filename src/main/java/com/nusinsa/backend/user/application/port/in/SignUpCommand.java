package com.nusinsa.backend.user.application.port.in;

import com.nusinsa.backend.user.domain.LoginId;
import com.nusinsa.backend.user.domain.Password;
import com.nusinsa.backend.user.domain.UserName;
import org.springframework.util.Assert;

public record SignUpCommand(LoginId loginId, Password password, UserName userName) {

    public SignUpCommand {
        Assert.notNull(loginId, "로그인 ID는 필수입니다.");
        Assert.notNull(password, "비밀번호는 필수입니다.");
        Assert.notNull(userName, "사용자 이름은 필수입니다.");
    }

}