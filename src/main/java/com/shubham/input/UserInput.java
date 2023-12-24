package com.shubham.input;

import com.shubham.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class UserInput {
    private String id;
    private String name;
    private String email;
    private AddressInput address;
    private List<CategoryInput> categories;
}
