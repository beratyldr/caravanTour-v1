package com.caravantour.caravan.model.mapper;

import com.caravantour.caravan.model.dto.CarDTO;
import com.caravantour.caravan.model.entity.car.CarModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Component
@RequiredArgsConstructor
public class CarMapper {

    private final CarBrandMapper carBrandMapper;

    public  CarModel toCarModel(CarDTO carDTO) {
        CarModel carModel = new CarModel();
        carModel.setPrice(carDTO.getPrice());
        carModel.setCapacity(carDTO.getCapacity());
        carModel.setCode(carDTO.getCode());
        carModel.setStatus(carDTO.getStatus());
        if(Objects.nonNull(carDTO.getBrand())) {
            carModel.setBrand(carBrandMapper.toCarBrandModel(carDTO.getBrand()));
        }

        return carModel;
    }
    public  CarDTO toCarDto(CarModel carModel) {
        CarDTO carDTO = new CarDTO();
        carDTO.setPrice(carModel.getPrice());
        carDTO.setCapacity(carModel.getCapacity());
        carDTO.setCode(carModel.getCode());
        carDTO.setStatus(carModel.getStatus());
        if(Objects.nonNull(carModel.getBrand())) {
            carDTO.setBrand(carBrandMapper.toCarBrandDTO(carModel.getBrand()));
        }

        return carDTO;
    }
    public  List<CarDTO> toCarDtoList(List<CarModel> carModel) {
        List<CarDTO> carDTOList=new ArrayList<>();
        for (CarModel car:carModel) {
            carDTOList.add(toCarDto(car));
        }

        return carDTOList;
    }
    public  List<CarModel> toCarModelList(List<CarDTO> carDTOS) {
        List<CarModel> carModels=new ArrayList<>();
        for (CarDTO car:carDTOS) {
            carModels.add(toCarModel(car));
        }

        return carModels;
    }
}
