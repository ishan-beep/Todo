package com.ishan.todo.repository;

import com.ishan.todo.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<LoginEntity ,Long> {
    Optional<LoginEntity> findByUsername(String username);
}
