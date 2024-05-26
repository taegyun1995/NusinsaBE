package com.nusinsa.backend.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginId {

    public static final int MIN_LENGTH = 6;
    public static final int MAX_LENGTH = 20;
    public static final String REGEX = "^[a-zA-Z0-9]{" + MIN_LENGTH + "," + MAX_LENGTH + "}$";

    @Column(name = "login_id")
    private String value;

    public LoginId(final String value) {
        validate(value);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var loginId = (LoginId) o;
        return Objects.equals(getValue(), loginId.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    private void validate(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("로그인 ID는 필수입니다.");
        }
        if (!value.matches(REGEX)) {
            throw new IllegalArgumentException("로그인 아이디는 " + MIN_LENGTH + " 자에서 " + MAX_LENGTH + " 자 사이의 영문 대소문자와 숫자로 이루어져야 합니다.");
        }
    }

}