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
@Table(name = "users")
@Entity
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
    public UserEntity(LoginId loginId, Password password, UserName userName, String userAgent) {
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.userAgent = userAgent;
    }

    public static UserEntity of(User user) {
        return UserEntity.builder()
                .loginId(user.getLoginId())
                .password(user.getPassword())
                .userName(user.getUserName())
                .userAgent(user.getUserAgent())
                .build();
    }

}