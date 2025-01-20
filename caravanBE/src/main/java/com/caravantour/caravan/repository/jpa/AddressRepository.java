package com.caravantour.caravan.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caravantour.caravan.model.entity.AddressModel;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, Integer> {
}
