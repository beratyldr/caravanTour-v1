package com.caravantour.caravan.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caravantour.caravan.facade.CarFacade;
import com.caravantour.caravan.model.dto.CarDTO;
import com.caravantour.caravan.service.CarService;

@Component
public class CarFacadeImpl implements CarFacade {
    @Autowired
    private CarService carService;

    @Override
    public List<CarDTO> getAllCars() {
        return carService.getAllCars();
    }

    @Override
    public CarDTO getCarByCode(String code) {
        return carService.findByCode(code);
    }

    @Override
    public void createCar(CarDTO carDTO) {
        carService.createCar(carDTO);
    }
}
