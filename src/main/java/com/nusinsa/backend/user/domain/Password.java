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
public class Password {

    @Column(name = "password")
    private String value;

    public Password(final String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var password = (Password) o;
        return Objects.equals(getValue(), password.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

}