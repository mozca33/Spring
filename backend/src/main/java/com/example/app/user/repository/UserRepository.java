package com.example.app.user.repository;

import org.springframework.stereotype.Repository;

import com.example.app.user.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
