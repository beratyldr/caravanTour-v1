package com.caravantour.caravan.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.caravantour.caravan.model.dto.UserDTO;

public interface UserService {

    UserDTO getCurrentUser();
    UserDetailsService getUserDetailsService();
}
