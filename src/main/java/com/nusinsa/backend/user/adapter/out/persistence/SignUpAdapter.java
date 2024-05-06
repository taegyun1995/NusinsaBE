package com.nusinsa.backend.user.adapter.out.persistence;

import com.nusinsa.backend.user.application.port.out.SignUpPort;
import com.nusinsa.backend.user.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class SignUpAdapter implements SignUpPort {

    private final JpaUserRepository jpaUserRepository;

    public SignUpAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public void signUp(User user) {
        UserEntity userEntity = UserEntity.of(user);
        jpaUserRepository.save(userEntity);
    }

}