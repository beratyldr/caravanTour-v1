package com.caravantour.caravan.model.mapper;

import com.caravantour.caravan.model.dto.RouteDTO;
import com.caravantour.caravan.model.entity.RouteModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class RouteMapper {
    public RouteModel toRouteModel(RouteDTO routeDTO) {
        RouteModel routeModel = new RouteModel();
        routeModel.setStartAddressModel(routeDTO.getStartAddressModel());
        routeModel.setEndAddressModel(routeDTO.getEndAddressModel());

        return routeModel;
    }

    public  List<RouteModel> toRouteModelList(List<RouteDTO> routeDTOS) {
        List<RouteModel> routeModelList=new ArrayList<>();
        for (RouteDTO route:routeDTOS) {
            routeModelList.add(toRouteModel(route));
        }

        return routeModelList;
    }

    public  List<RouteDTO> toRouteDTOList(List<RouteModel> routes) {
        List<RouteDTO> routeDTOS=new ArrayList<>();
        for (RouteModel route:routes) {
            routeDTOS.add(toRouteDTO(route));
        }

        return routeDTOS;    }

    private  RouteDTO toRouteDTO(RouteModel route) {
        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setStartAddressModel(route.getStartAddressModel());
        routeDTO.setEndAddressModel(route.getEndAddressModel());
        return routeDTO;
    }
}
