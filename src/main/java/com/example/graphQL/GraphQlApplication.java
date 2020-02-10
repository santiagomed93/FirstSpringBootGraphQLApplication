package com.example.graphQL;

import com.example.graphQL.entity.Bike;
import com.example.graphQL.repository.BikeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BikeRepository bikeRepository){
		return (args) -> {
			bikeRepository.save(new Bike("Anaconda", "santiago.medina", "Bike example1"));
			bikeRepository.save(new Bike("Scoot", "felipe.medina", "Bike example2"));
			bikeRepository.save(new Bike("GW", "fernando.medina", "Bike example3"));
		};
	}

}
