
package com.example.swp391.service;

import org.springframework.stereotype.Service;

import com.example.swp391.domain.Role;
import com.example.swp391.repository.RoleRepository;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
