package com.shubham.repository;

import com.shubham.model.HousingLocation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HousingLocationRepository extends MongoRepository<HousingLocation, String> {

    List<HousingLocation> findAllByCityContaining(String query);

}
