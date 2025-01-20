package com.caravantour.caravan.controller;

import com.caravantour.caravan.facade.CarFacade;
import com.caravantour.caravan.model.dto.CarDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class CarsController {
    private final CarFacade carFacade;


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/createCar")
    public void createCar(@RequestBody CarDTO carDTO) {
        carFacade.createCar(carDTO);
    }


    @GetMapping("/getCar/{code}")
    public CarDTO getCarByCode(@PathVariable String code) {
        return carFacade.getCarByCode(code);
    }

    @GetMapping("/getAllCar")
    public List<CarDTO> getAllCar() {
        return carFacade.getAllCars();
    }
}
