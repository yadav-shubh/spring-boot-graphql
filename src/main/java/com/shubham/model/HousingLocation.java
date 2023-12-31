package com.shubham.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "housing_locations")
public class HousingLocation {

    @Id
    private String id;
    private String name;
    private String city;
    private String state;
    private String photo;
    private int availableUnits;
    private boolean wifi;
    private boolean laundry;
}

