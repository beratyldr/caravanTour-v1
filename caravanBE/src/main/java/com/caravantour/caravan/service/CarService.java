package com.caravantour.caravan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.caravantour.caravan.model.dto.CarDTO;

@Service
public interface CarService {
    List<CarDTO> getAllCars();
    //CarDTO getCarByCode(String code);
    void createCar(CarDTO carDTO);
    CarDTO findByCode(String id);
}
