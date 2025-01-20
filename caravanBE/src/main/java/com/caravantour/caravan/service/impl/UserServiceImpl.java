package com.caravantour.caravan.service.impl;

import com.caravantour.caravan.model.UserDetailsImpl;
import com.caravantour.caravan.model.dto.UserDTO;
import com.caravantour.caravan.model.entity.User;
import com.caravantour.caravan.model.mapper.UserMapper;
import com.caravantour.caravan.repository.jpa.UserRepository;
import com.caravantour.caravan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserDetailsService getUserDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
                return UserDetailsImpl.build(user);
            }
        };
    }

    @Override
    public UserDTO getCurrentUser() {
        if ("anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
            return null;
        }
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userMapper.toUserDTO(userRepository.findByEmail(principal.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User Not Found")));

    }
}
