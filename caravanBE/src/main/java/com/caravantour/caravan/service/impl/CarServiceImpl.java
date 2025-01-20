package com.caravantour.caravan.service.impl;

import com.caravantour.caravan.model.dto.CarDTO;
import com.caravantour.caravan.model.entity.car.CarBrandModel;
import com.caravantour.caravan.model.entity.car.CarModel;
import com.caravantour.caravan.model.mapper.CarMapper;
import com.caravantour.caravan.repository.elastic.CarRepository;
import com.caravantour.caravan.repository.jpa.CarBrandRepository;
import com.caravantour.caravan.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarBrandRepository carBrandRepository;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<CarDTO> getAllCars() {
        List<CarModel> carModels = (List<CarModel>) carRepository.findAll();
        return carMapper.toCarDtoList(carModels);
    }

/*    @Override
    public CarDTO getCarByCode(String code) {
        return carMapper.toCarDto(carsRepository.findByCode(code));
    }*/

    @Override
    public void createCar(CarDTO carDTO) {
        CarModel carModel = carMapper.toCarModel(carDTO);
        CarBrandModel carBrandModel = carBrandRepository.findByCode(carDTO.getBrand().getCode());
        if (Objects.nonNull(carBrandModel)) {
            carModel.setBrand(carBrandModel);
        }
        carRepository.save(carModel);
    }

    @Override
    public CarDTO findByCode(String id) {
        CarModel carModel = carRepository.findByCode(id);
        if (carModel != null) {
            return carMapper.toCarDto(carModel);
        }
        return null;
    }
}
