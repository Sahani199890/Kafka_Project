package com.dev.kafka.repository;

import com.dev.kafka.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<UsersEntity, String> {
    Optional<UsersEntity> findByEmail(String username);
}