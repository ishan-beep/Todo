package com.ishan.todo.repository;

import com.ishan.todo.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity,Long> {
        LoginEntity findByUsername(String username);
}
