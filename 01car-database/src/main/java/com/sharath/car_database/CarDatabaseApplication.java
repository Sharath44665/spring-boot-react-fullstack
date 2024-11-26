package com.sharath.car_database;

import com.sharath.car_database.domain.Car;
import com.sharath.car_database.domain.CarRepository;
import com.sharath.car_database.domain.Owner;
import com.sharath.car_database.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CarDatabaseApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CarDatabaseApplication.class);
	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;

    public CarDatabaseApplication(CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(CarDatabaseApplication.class, args);
		logger.info("my car database app started");
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner0 = new Owner("Sharath" , "chandra");
		Owner owner1 = new Owner("John" , "Johnson");
		Owner owner2 = new Owner("Mary" , "Robinson");
		Owner owner3 = new Owner("Smita" , "diva");
		Owner owner4 = new Owner("user" , "four");

		ownerRepository.saveAll(Arrays.asList(owner0, owner1, owner2, owner3, owner4 ));

		carRepository.save(new Car("Ford", "Mustang", "Red",
				"ADF-1121", 2023, 59000, owner0 ));
		carRepository.save(new Car("Nissan", "Leaf", "White",
				"SSJ-3002", 2020, 29000, owner1 ));
		carRepository.save(new Car("Toyota", "Prius",
				"Silver", "KKO-0212", 2022, 39000, owner2 ));

		carRepository.save(new Car("Ford", "Mustang", "yellow",
				"ADF-1121", 2022, 55000, owner3 ));
		carRepository.save(new Car("Ford", "Focus", "white",
				"PAS-1122", 2020, 55000 , owner4));
		carRepository.save(new Car("Toyota", "Innova", "White",
				"KA-1121", 2023, 59000 , owner0));


		for(Car car : carRepository.findAll()){
			logger.info("brand: {}, model: {}", car.getBrand(), car.getModel());
		}

		System.out.println("----findByBrand--------");
		for ( Car car: carRepository.findByBrand("Ford")){
			System.out.println(car);
		}

		System.out.println("----findByBrandOrderByModelYearAsc--------");
		for(Car car: carRepository.findByBrandOrderByModelYearAsc("Ford")){
			System.out.println(car);
		}

		System.out.println("----findByBrandEndsWith--------");
		for(Car car: carRepository.findByBrandEndsWith("rd")){
			System.out.println(car);
		}
	}
}
