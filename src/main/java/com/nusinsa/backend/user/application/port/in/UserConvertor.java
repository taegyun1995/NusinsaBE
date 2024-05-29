package com.nusinsa.backend.user.application.port.in;

import com.nusinsa.backend.user.adapter.out.persistence.UserEntity;
import com.nusinsa.backend.user.domain.User;

public class UserConvertor {

    public static User toDomainUser(String userAgent, SignUpCommand command) {
        return User.builder()
                .loginId(command.loginId())
                .password(command.password())
                .userName(command.userName())
                .userAgent(userAgent)
                .build();
    }

    public static UserEntity toUserEntity(final User user) {
        return UserEntity.builder()
                .loginId(user.getLoginId())
                .password(user.getPassword())
                .userName(user.getUserName())
                .userAgent(user.getUserAgent())
                .build();
    }

}