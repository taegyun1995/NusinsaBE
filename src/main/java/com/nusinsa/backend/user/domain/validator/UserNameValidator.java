package com.nusinsa.backend.user.domain.validator;

import com.nusinsa.backend.user.domain.UserName;
import org.springframework.stereotype.Component;

@Component
public class UserNameValidator implements UserValidator<UserName> {

    private static final String USERNAME_FIELD_NAME = "사용자 이름";

    @Override
    public void validate(UserName userName) {
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