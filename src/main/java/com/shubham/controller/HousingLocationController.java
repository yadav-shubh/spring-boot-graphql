package com.shubham.controller;

import com.shubham.model.HousingLocation;
import com.shubham.repository.HousingLocationRepository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class HousingLocationController {

    private final HousingLocationRepository housingLocationRepository;

    public HousingLocationController(HousingLocationRepository housingLocationRepository) {
        this.housingLocationRepository = housingLocationRepository;
    }

    @RequestMapping("/housing-locations")
    public List<HousingLocation> getAllHousingLocations(@RequestParam(value = "query", required = false) String query) {
        if (StringUtils.hasLength(query)) {
            return housingLocationRepository.findAllByCityContaining(query);
        } else {
            return housingLocationRepository.findAll().subList(0, 4);
        }
    }

    @RequestMapping("/housing-locations/{id}")
    public HousingLocation findOne(@PathVariable String id) {
        return housingLocationRepository.findById(id).orElse(null);
    }
}
