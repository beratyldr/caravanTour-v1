package com.caravantour.caravan.model.mapper;

import com.caravantour.caravan.model.dto.UserDTO;
import com.caravantour.caravan.model.entity.RoleEntity;
import com.caravantour.caravan.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class UserMapper {

    public  UserDTO toUserDTO(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());

        return userDto;
    }

    public  User toUser(UserDTO userDTO) {
        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setRoles(userDTO.getRoles());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return user;
    }
}
