package com.java.jquery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.jquery.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByEmail(String email);
}
