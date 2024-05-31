package com.nusinsa.backend.user.domain.validator;

import com.nusinsa.backend.user.domain.Password;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator implements UserValidator<Password>{

    private static final String PASSWORD_FIELD_NAME = "비밀번호";

    @Override
    public void validate(Password password) {
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

}