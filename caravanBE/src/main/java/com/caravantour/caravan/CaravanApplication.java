package com.caravantour.caravan;

import com.caravantour.caravan.model.entity.RoleEntity;
import com.caravantour.caravan.model.entity.User;
import com.caravantour.caravan.model.enums.UserRole;
import com.caravantour.caravan.repository.jpa.RoleRepository;
import com.caravantour.caravan.repository.jpa.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class CaravanApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(CaravanApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        RoleEntity role1 = new RoleEntity();
        role1.setName(UserRole.ROLE_USER);
        if (Objects.isNull(roleRepository.findByName(role1.getName()))) {

            roleRepository.save(role1);
        }

        RoleEntity role2 = new RoleEntity();
        role2.setName(UserRole.ROLE_MODERATOR);
        if (Objects.isNull(roleRepository.findByName(role2.getName()))) {
            roleRepository.save(role2);
        }
        RoleEntity role3 = new RoleEntity();
        role3.setName(UserRole.ROLE_ADMIN);
        if (Objects.isNull(roleRepository.findByName(role3.getName()))) {
            roleRepository.save(role3);
        }

        Optional<User> adminAcc = userRepository.findByEmail("admin@gmail.com");
        if (adminAcc.isEmpty()) {
            User user = new User();
            user.setEmail("admin@gmail.com");
            user.setFirstName("admin");
            user.setLastName("admin");
            Set<RoleEntity> roles = new HashSet<>();
            roles.add(role3);
            user.setRoles(roles);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }
        Optional<User> userAcc = userRepository.findByEmail("test@gmail.com");
        if (userAcc.isEmpty()) {
            User user = new User();
            user.setEmail("test@gmail.com");
            user.setFirstName("test");
            user.setLastName("test");
            Set<RoleEntity> roles = new HashSet<>();
            roles.add(role1);
            user.setRoles(roles);
            user.setPassword(new BCryptPasswordEncoder().encode("test"));
            userRepository.save(user);
        }

    }
}
