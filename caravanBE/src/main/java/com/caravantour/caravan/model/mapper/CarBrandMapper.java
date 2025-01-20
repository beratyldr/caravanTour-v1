package com.caravantour.caravan.model.mapper;

import com.caravantour.caravan.model.dto.CarBrandDTO;
import com.caravantour.caravan.model.entity.car.CarBrandModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class CarBrandMapper {
    public  CarBrandModel toCarBrandModel(CarBrandDTO carBrandDTO) {
        CarBrandModel carBrandModel = new CarBrandModel();
        carBrandModel.setName(carBrandDTO.getName());
        carBrandModel.setCode(carBrandDTO.getCode());
        carBrandModel.setModel(carBrandDTO.getModel());

        return carBrandModel;
    }

    public CarBrandDTO toCarBrandDTO(CarBrandModel carBrandModel) {
        CarBrandDTO carBrandDTO = new CarBrandDTO();
        carBrandDTO.setName(carBrandModel.getName());
        carBrandDTO.setCode(carBrandModel.getCode());
        carBrandDTO.setModel(carBrandModel.getModel());

        return carBrandDTO;
    }
}
