package com.caravantour.caravan.model.entity.car;

import com.caravantour.caravan.model.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "carbrand")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarBrandModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String model;
    @Column(unique = true)
    private String code;
    @OneToMany(mappedBy = "brand")
    private List<CarModel> cars;
}
