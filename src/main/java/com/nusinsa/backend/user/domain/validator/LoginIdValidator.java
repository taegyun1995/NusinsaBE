package com.nusinsa.backend.user.domain.validator;

import com.nusinsa.backend.user.domain.LoginId;

public class LoginIdValidator implements UserValidator<LoginId> {

    private static final String LOGIN_ID_FIELD_NAME = "로그인 ID";

    @Override
    public void validate(LoginId loginId) {
        String fieldValue = loginId.getValue();
        if (fieldValue == null || fieldValue.isEmpty()) {
            throw new IllegalArgumentException(LOGIN_ID_FIELD_NAME + "는 필수입니다.");
        }
        if (!fieldValue.matches(LoginId.REGEX)) {
            throw new IllegalArgumentException(
                    String.format(
                            "%s는 %d 자에서 %d 자 사이의 영문 대소문자와 숫자로 이루어져야 합니다.", LOGIN_ID_FIELD_NAME, LoginId.MIN_LENGTH, LoginId.MAX_LENGTH
                    )
            );
        }
    }

}