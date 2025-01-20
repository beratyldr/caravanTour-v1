package com.caravantour.caravan.model.dto;

import com.caravantour.caravan.model.entity.car.CarModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarBrandDTO {
    private String model;
    private String code;
    private String name;
    private List<CarModel> cars;
}
