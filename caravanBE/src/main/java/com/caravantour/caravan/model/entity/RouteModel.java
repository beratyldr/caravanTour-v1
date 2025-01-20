package com.caravantour.caravan.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "route")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int priority;

    @OneToOne
    @JoinColumn(name = "start_address_id")
    private AddressModel startAddressModel;

    @OneToOne
    @JoinColumn(name = "end_address_id")
    private AddressModel endAddressModel;

    @ManyToMany(mappedBy = "routes")
    private List<TourModel> tours;
}
