package com.gunni.gunnihaeba.domain.domain.repository;

import com.gunni.gunnihaeba.domain.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserId(String userId);
    boolean existsByUserId(String userId);
}
