package com.nusinsa.backend.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = PROTECTED)
public class Password {

    public static final int MIN_LENGTH = 8;
    public static final int MAX_LENGTH = 20;
    public static final String REGEX = "^[a-zA-Z0-9]{" + MIN_LENGTH + "," + MAX_LENGTH + "}$";

    @Column(name = "password")
    private String value;

    public Password(final String value) {
        this.value = value;
    }

}