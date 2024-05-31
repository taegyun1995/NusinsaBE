package com.nusinsa.backend.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = PROTECTED)
public class UserName {

    public static final int MIN_LENGTH = 2;
    public static final int MAX_LENGTH = 20;
    public static final String REGEX = "^[a-zA-Z0-9가-힣]{" + MIN_LENGTH + "," + MAX_LENGTH + "}$";

    @Column(name = "user_name")
    private String value;

    public UserName(final String value) {
        this.value = value;
    }

}