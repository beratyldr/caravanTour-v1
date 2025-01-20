package com.caravantour.caravan.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caravantour.caravan.model.entity.RoleEntity;
import com.caravantour.caravan.model.enums.UserRole;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByName(UserRole name);
}