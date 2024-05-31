package com.nusinsa.backend.user.adapter.out.persistence;

import com.nusinsa.backend.advice.entityBase.TimeEntity;
import com.nusinsa.backend.user.domain.*;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Embedded
    private LoginId loginId;

    @Embedded
    private Password password;

    @Embedded
    private UserName userName;

    private String userAgent;

    @Builder
    public UserEntity(final LoginId loginId, final Password password, final UserName userName, final String userAgent) {
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.userAgent = userAgent;
    }

}