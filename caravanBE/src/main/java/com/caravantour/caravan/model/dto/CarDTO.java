package com.caravantour.caravan.model.dto;

import com.caravantour.caravan.model.enums.CarStatusType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO {
    private String code;
    private String name;
    private CarBrandDTO brand;
    private int constructionYear;
    private String segment;
    private int capacity;
    private Double price;
    private CarStatusType status;
}
