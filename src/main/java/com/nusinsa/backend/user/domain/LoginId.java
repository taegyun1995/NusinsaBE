package com.nusinsa.backend.user.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginId {

    private String value;

    public LoginId(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginId loginId = (LoginId) o;
        return Objects.equals(getValue(), loginId.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

}