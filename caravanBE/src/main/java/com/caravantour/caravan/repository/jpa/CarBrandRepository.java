package com.caravantour.caravan.repository.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caravantour.caravan.model.entity.car.CarBrandModel;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrandModel, Integer> {
    CarBrandModel findByCode(String Code);

}
