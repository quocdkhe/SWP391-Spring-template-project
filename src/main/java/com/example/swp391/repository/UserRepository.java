package com.example.swp391.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swp391.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);

    User save(User user);

    User findByUsername(String username);

    boolean existsByUsername(String username);
}
