package com.shubham.datafeeder;

import com.shubham.model.HousingLocation;
import com.shubham.repository.HousingLocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class RandomDataGenerator implements CommandLineRunner {

    private final HousingLocationRepository housingLocationRepository;

    public RandomDataGenerator(HousingLocationRepository housingLocationRepository) {
        this.housingLocationRepository = housingLocationRepository;
    }

    private static List<HousingLocation> generateRandomData(int count) {
        List<HousingLocation> housingLocations = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= count; i++) {
            String stringId = String.valueOf(i);
            HousingLocation housingLocation = new HousingLocation(stringId, generateRandomName(), generateRandomCity(), generateRandomState(), generateRandomPhotoUrl(), random.nextInt(10) + 1,  // Random available units between 1 and 10
                    random.nextBoolean(), random.nextBoolean());
            housingLocations.add(housingLocation);
        }
        return housingLocations;
    }

    private static String generateRandomName() {
        return "Random Name " + new Random().nextInt(100);
    }

    private static String generateRandomCity() {
        return "City" + new Random().nextInt(10);
    }

    private static String generateRandomState() {
        return "State" + new Random().nextInt(5);
    }

    private static String generateRandomPhotoUrl() {
        return "https://source.unsplash.com/1600x900/?house&random=" + Math.random();
    }

    @Override
    public void run(String... args) {

        List<HousingLocation> housingLocations = generateRandomData(100000);

        for (int i = 1; i < housingLocations.size(); i++) {
            Optional<HousingLocation> housingLocationOptional = housingLocationRepository.findById(String.valueOf(i));
            if (housingLocationOptional.isEmpty()) {
                System.out.println(housingLocationOptional);
                housingLocationRepository.save(housingLocations.get(i));
            }

        }

        System.out.println("Data generated successfully");

    }
}

