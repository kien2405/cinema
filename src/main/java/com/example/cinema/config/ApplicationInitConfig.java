package com.example.cinema.config;


import com.example.cinema.entity.UserEntity;
import com.example.cinema.enums.Role;
import com.example.cinema.repository.RoleRepository;
import com.example.cinema.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
@Slf4j
public class ApplicationInitConfig {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;


    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository){
        return args -> {
           if (userRepository.findByUsernameAndIsActive("admin", true).isEmpty()){
               var roles = new HashSet<String>();
               roles.add(Role.ADMIN.name());
               UserEntity user = UserEntity.builder()
                       .username("admin")
                       .isActive(true)
                       .password(passwordEncoder.encode("admin"))
                       .role(roleRepository.findByCode("ADMIN"))
                       .build();

               userRepository.save(user);
               log.warn("Admin user has been created with default password: admin, Please change it");
           }
        };
    }
}
