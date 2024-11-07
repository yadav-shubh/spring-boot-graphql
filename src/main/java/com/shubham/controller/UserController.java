package com.shubham.controller;

import com.shubham.input.UserInput;
import com.shubham.model.User;
import com.shubham.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/users/all")
    public String createUser(@RequestBody User user) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Running " + Thread.currentThread().toString());
        return "after 1 second";
    }

    @GetMapping("/users/all")
    public String getAllUsers() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Running " + Thread.currentThread());
        return "after 1 second";
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
