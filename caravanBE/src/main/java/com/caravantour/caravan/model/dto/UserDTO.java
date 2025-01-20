package com.caravantour.caravan.model.dto;


import com.caravantour.caravan.model.entity.RoleEntity;
import com.caravantour.caravan.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserRole role;
    private Set<RoleEntity> roles;
    private String token;
}