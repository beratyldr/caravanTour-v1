//package com.caravantour.caravan.model.entity;
//
//import com.caravantour.caravan.model.entity.car.CarModel;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "price")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class PriceModel extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private Long pricaValue;
//
//    @OneToOne
//    @JoinColumn(name = "car_id")
//    private CarModel car;
//}
