package com.nusinsa.backend.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Embeddable
@NoArgsConstructor(access = PROTECTED)
public class UserName {

    public static final int MIN_LENGTH = 2;
    public static final int MAX_LENGTH = 20;
    public static final String REGEX = "^[a-zA-Z0-9가-힣]{" + MIN_LENGTH + "," + MAX_LENGTH + "}$";

    @Column(name = "user_name")
    private String value;

    public UserName(final String value) {
        validate(value);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var userName = (UserName) o;
        return Objects.equals(getValue(), userName.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    private void validate(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("사용자 이름은 필수입니다.");
        }
        if (!value.matches(REGEX)) {
            throw new IllegalArgumentException("사용자 이름은 " + MIN_LENGTH + " 자에서 " + MAX_LENGTH + " 자 사이의 한글, 영문 대소문자와 숫자로 이루어져야 합니다.");
        }
    }

}