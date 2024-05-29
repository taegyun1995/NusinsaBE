package com.nusinsa.backend.user.application.port.in;

import com.nusinsa.backend.user.domain.LoginId;
import com.nusinsa.backend.user.domain.Password;
import com.nusinsa.backend.user.domain.User;
import com.nusinsa.backend.user.domain.UserName;

public class UserValidator {

    private static final String LOGIN_ID_FIELD_NAME = "로그인 ID";
    private static final String PASSWORD_FIELD_NAME = "비밀번호";
    private static final String USERNAME_FIELD_NAME = "사용자 이름";

    public void validate(final User user) {
        loginIdValidate(user.getLoginId());
        passwordValidate(user.getPassword());
        userNameValidate(user.getUserName());
    }

    private void loginIdValidate(final LoginId loginId) {
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

    private void passwordValidate(final Password password) {
        String fieldValue = password.getValue();
        if (fieldValue == null || fieldValue.isEmpty()) {
            throw new IllegalArgumentException(PASSWORD_FIELD_NAME + "는 필수입니다.");
        }
        if (!fieldValue.matches(Password.REGEX)) {
            throw new IllegalArgumentException(
                    String.format(
                            "%s는 %d 자에서 %d 자 사이의 영문 대소문자와 숫자로 이루어져야 합니다.", PASSWORD_FIELD_NAME, Password.MIN_LENGTH, Password.MAX_LENGTH
                    )
            );
        }
    }

    private void userNameValidate(final UserName userName) {
        String fieldValue = userName.getValue();
        if (fieldValue == null || fieldValue.isEmpty()) {
            throw new IllegalArgumentException(USERNAME_FIELD_NAME + "는 필수입니다.");
        }
        if (!fieldValue.matches(UserName.REGEX)) {
            throw new IllegalArgumentException(
                    String.format(
                            "%s는 %d 자에서 %d 자 사이의 영문 대소문자와 숫자로 이루어져야 합니다.", USERNAME_FIELD_NAME, UserName.MIN_LENGTH, UserName.MAX_LENGTH
                    )
            );
        }
    }

}