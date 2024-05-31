package com.nusinsa.backend.user.adapter.out.persistence.signUp;

import com.nusinsa.backend.common.Adapter;
import com.nusinsa.backend.user.adapter.out.persistence.JpaUserRepository;
import com.nusinsa.backend.user.adapter.out.persistence.UserEntity;
import com.nusinsa.backend.user.application.port.in.common.UserConvertor;
import com.nusinsa.backend.user.application.port.out.signUp.SignUpPort;
import com.nusinsa.backend.user.domain.LoginId;
import com.nusinsa.backend.user.domain.User;

@Adapter
public class SignUpAdapter implements SignUpPort {

    private final JpaUserRepository jpaUserRepository;

    public SignUpAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public void signUp(final User user) {
        UserEntity userEntity = UserConvertor.toUserEntity(user);
        jpaUserRepository.save(userEntity);
    }

    @Override
    public boolean existsByLoginId(LoginId loginId) {
        return jpaUserRepository.existsByLoginId(loginId);
    }

}