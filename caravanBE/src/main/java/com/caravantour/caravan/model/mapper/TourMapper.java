package com.caravantour.caravan.model.mapper;

import com.caravantour.caravan.model.dto.TourDTO;
import com.caravantour.caravan.model.entity.RouteModel;
import com.caravantour.caravan.model.entity.TourModel;
import com.caravantour.caravan.model.entity.car.CarModel;
import com.caravantour.caravan.repository.elastic.CarRepository;
import com.caravantour.caravan.repository.jpa.RouteRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class TourMapper {

    private final CarRepository carRepository;
    private final RouteMapper routeMapper;
    private final CarMapper carMapper;
    private final RouteRepository routeRepository;
    public TourModel toTourModel(TourDTO tourDTO) {
        TourModel tourModel = new TourModel();
        tourModel.setPrice(tourDTO.getPrice());

        if (Objects.nonNull(tourDTO.getRouteModels())) {
            List<RouteModel> routeModels=new ArrayList<>();
            for (String routeId: tourDTO.getRouteIds()) {
                Optional<RouteModel> routeModel=routeRepository.findById(Long.valueOf(routeId));
                routeModel.ifPresent(routeModels::add);
            }
            tourModel.setRoutes(routeModels);
        }
        tourModel.setCode(tourDTO.getCode());
        if (Objects.nonNull(tourDTO.getCarsCode())) {
            List<CarModel> cars=new ArrayList<>();
            for(String carCode: tourDTO.getCarsCode()){
                CarModel car=carRepository.findByCode(carCode);
                cars.add(car);
            }
            tourModel.setCars(cars);
        }
        tourModel.setEndDate(tourDTO.getEndDate());
        tourModel.setStartDate(tourDTO.getStartDate());

        return tourModel;
    }

    public List<TourDTO> toTourDTOList(List<TourModel> tourModels) {
        List<TourDTO> tourDTOS = new ArrayList<>();
        for (TourModel tour : tourModels) {
            tourDTOS.add(toTourDTO(tour));
        }
        return tourDTOS;
    }

    private TourDTO toTourDTO(TourModel tour) {
        TourDTO tourDTO = new TourDTO();
        tourDTO.setPrice(tour.getPrice());
        tourDTO.setCars(carMapper.toCarDtoList(tour.getCars()));
        tourDTO.setCode(tour.getCode());
        tourDTO.setRouteModels(routeMapper.toRouteDTOList(tour.getRoutes()));
        tourDTO.setEndDate(tourDTO.getEndDate());
        tourDTO.setStartDate(tourDTO.getStartDate());
        return tourDTO;
    }
}
