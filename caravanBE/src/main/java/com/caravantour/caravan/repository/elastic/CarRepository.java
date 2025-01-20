package com.caravantour.caravan.repository.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.caravantour.caravan.model.entity.car.CarModel;

@Repository
public interface CarRepository extends ElasticsearchRepository<CarModel, String> {
    CarModel findByCode(String code);

}