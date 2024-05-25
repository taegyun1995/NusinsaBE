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

    @Column(name = "user_name")
    private String value;

    public UserName(final String value) {
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

}