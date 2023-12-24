package com.shubham.controller;

import com.shubham.input.UserInput;
import com.shubham.model.User;
import com.shubham.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryMapping("users")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @MutationMapping("createUser")
    public User create(@Argument UserInput user) {
        User saveUser = new User();
        saveUser.setName(user.getName());
        saveUser.setEmail("shubham@gmail.com");
        return userRepository.save(saveUser);
    }

}
