package com.assignment.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.models.Role;
import com.assignment.models.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}

