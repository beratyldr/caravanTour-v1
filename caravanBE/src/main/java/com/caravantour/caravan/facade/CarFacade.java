package com.caravantour.caravan.facade;


import com.caravantour.caravan.model.dto.CarDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarFacade {
    List<CarDTO> getAllCars();
    CarDTO getCarByCode(String code);
    void createCar(CarDTO carDTO);
}
