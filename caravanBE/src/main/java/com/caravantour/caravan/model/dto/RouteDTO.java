package com.caravantour.caravan.model.dto;

import com.caravantour.caravan.model.entity.AddressModel;
import com.caravantour.caravan.model.entity.TourModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RouteDTO {
    private AddressModel startAddressModel;
    private AddressModel endAddressModel;
    private TourModel tour;

}
