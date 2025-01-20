package com.caravantour.caravan.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TourDTO {
    private String code;
    private Date startDate;
    private Date endDate;
    private List<RouteDTO> routeModels;
    private Double price;
    private List<String> carsCode;
    private List<String> routeIds;
    private List<CarDTO> cars;
}
