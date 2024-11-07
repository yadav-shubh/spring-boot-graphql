package com.shubham.controller;

import com.shubham.model.HousingLocation;
import com.shubham.repository.HousingLocationRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
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

    @GetMapping("/housing-locations")
    public List<HousingLocation> getAllHousingLocations(@RequestParam(value = "query", required = false) String query) {
        if (StringUtils.hasLength(query)) {
            return housingLocationRepository.findAllByCityContaining(query);
        } else {
            return housingLocationRepository.findAll();
        }
    }

    @RequestMapping("/housing-locations/{id}")
    public HousingLocation findById(@PathVariable String id) {
        return housingLocationRepository.findById(id).orElse(null);
    }

    @QueryMapping("housingLocations")
    public List<HousingLocation> findAll() {
        return housingLocationRepository.findAll();
    }

    @QueryMapping("housingLocation")
    public HousingLocation findOne(@Argument String id) {
        return housingLocationRepository.findById(id).orElse(null);
    }
}
