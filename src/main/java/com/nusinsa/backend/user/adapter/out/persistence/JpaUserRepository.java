package com.nusinsa.backend.user.adapter.out.persistence;

import com.nusinsa.backend.user.domain.LoginId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByLoginId(final LoginId loginId);

}