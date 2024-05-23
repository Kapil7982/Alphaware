package com.assignment.dto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.assignment.models.Role;
import com.assignment.models.RoleName;
import com.assignment.repositories.RoleRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByName(RoleName.ROLE_USER).isEmpty()) {
            Role userRole = new Role();
            userRole.setName(RoleName.ROLE_USER);
            roleRepository.save(userRole);
        }

        if (roleRepository.findByName(RoleName.ROLE_ADMIN).isEmpty()) {
            Role adminRole = new Role();
            adminRole.setName(RoleName.ROLE_ADMIN);
            roleRepository.save(adminRole);
        }
    }
}

