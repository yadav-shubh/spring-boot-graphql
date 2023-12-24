package com.shubham.input;

import lombok.Data;

@Data
public class AddressInput {
    private String id;
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
