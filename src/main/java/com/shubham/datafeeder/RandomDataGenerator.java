package com.shubham.datafeeder;

import com.shubham.model.HousingLocation;
import com.shubham.repository.HousingLocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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
            HousingLocation housingLocation = new HousingLocation(String.valueOf(i), generateRandomName(), generateRandomCity(), generateRandomState(), generateRandomPhotoUrl(), random.nextInt(10) + 1,  // Random available units between 1 and 10
                    random.nextBoolean(),    // Random wifi availability
                    random.nextBoolean()     // Random laundry availability
            );

            housingLocations.add(housingLocation);
        }

        return housingLocations;
    }

    private static String generateRandomName() {
        // Logic to generate a random name
        // You can use a library or a predefined list of names for more realistic data
        return "Random Name " + new Random().nextInt(100);
    }

    private static String generateRandomCity() {
        // Logic to generate a random city
        return "City" + new Random().nextInt(10);
    }

    private static String generateRandomState() {
        // Logic to generate a random state
        return "State" + new Random().nextInt(5);
    }

    private static String generateRandomPhotoUrl() {
        // Logic to generate a random photo URL
        return "https://example.com/random-photo" + new Random().nextInt(100) + ".jpg";
    }

    @Override
    public void run(String... args) {
        List<HousingLocation> housingLocations = housingLocationRepository.findAll();
        for (HousingLocation housingLocation : housingLocations) {
            housingLocation.setPhoto("https://source.unsplash.com/1600x900/?house&random=" + Math.random());
//            housingLocationRepository.save(housingLocation);
        }
    }
}

