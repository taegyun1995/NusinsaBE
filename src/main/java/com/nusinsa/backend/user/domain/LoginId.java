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

}