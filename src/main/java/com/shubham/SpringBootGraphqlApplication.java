package com.shubham;

import com.shubham.model.User;
import com.shubham.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
public class SpringBootGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGraphqlApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            System.out.println("Running");
//            AtomicLong id = new AtomicLong(1);
//            User user = new User();
//            long newId = id.getAndAdd(1);
//            user.setName("user" + newId);
//            user.setEmail("email" + newId);
//            userRepository.save(user);
        };
    }
}
