package com.nusinsa.backend.user.application.port.out;

import com.nusinsa.backend.user.domain.LoginId;
import com.nusinsa.backend.user.domain.User;

public interface SignUpPort {

    void signUp(final User user);
    boolean existsByLoginId(final LoginId loginId);

}