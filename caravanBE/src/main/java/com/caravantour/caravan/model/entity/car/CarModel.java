package com.caravantour.caravan.model.entity.car;

import com.caravantour.caravan.model.entity.BaseEntity;
import com.caravantour.caravan.model.entity.TourModel;
import com.caravantour.caravan.model.entity.User;
import com.caravantour.caravan.model.enums.CarStatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "cars")
public class CarModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(unique = true)
    private String code;

    @Column(unique = true)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carbrand_id")
    private CarBrandModel brand;

    private int constructionYear;
    private String segment;
    private int capacity;
    private Double price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarStatusType status;

    private String description;
    private String imgUrl;
    private String carPlate;

    @ManyToOne(cascade = CascadeType.ALL)
    private User owner;

    @ManyToMany(mappedBy = "cars")
    private List<TourModel> tours;
    //TODO ilan başlığı,görsel description
}
