package com.rento.rento.common.jwt.respository;

import com.rento.rento.common.jwt.entity.JwtRefresh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JwtRefreshRepository extends JpaRepository<JwtRefresh, Long> {

    Optional<JwtRefresh> findByRefreshToken(String token);
    Boolean existsByRefreshToken(String token);

    Optional<JwtRefresh> findByManagerId(Long managerId);
}