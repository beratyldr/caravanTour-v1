package com.caravantour.caravan.controller;

import com.caravantour.caravan.model.dto.TourDTO;
import com.caravantour.caravan.model.entity.TourModel;
import com.caravantour.caravan.model.mapper.TourMapper;
import com.caravantour.caravan.repository.jpa.TourRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class TourController {

    private final TourRepository tourRepository;
    private final TourMapper tourMapper;

    @GetMapping("/getAllTour")
    public ResponseEntity<List<TourDTO>> getAllTour(){
        return ResponseEntity.ok().body(tourMapper.toTourDTOList(tourRepository.findAll()));
    }
    @PostMapping("/createTour")
    public ResponseEntity<TourModel> createTour(@RequestBody TourDTO tourDTO){
        TourModel tourModel = tourMapper.toTourModel(tourDTO);
        return ResponseEntity.ok().body(tourRepository.save(tourModel));
    }

}
