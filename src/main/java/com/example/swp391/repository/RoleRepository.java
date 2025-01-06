package com.example.swp391.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swp391.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role save(Role role);

    Role findByName(String name);
}
