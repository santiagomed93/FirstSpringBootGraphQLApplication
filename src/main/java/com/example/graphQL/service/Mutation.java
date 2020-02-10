package com.example.graphQL.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphQL.entity.Bike;
import com.example.graphQL.exception.BikeNotFoundException;
import com.example.graphQL.repository.BikeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Mutation implements GraphQLMutationResolver {

    private BikeRepository bikeRepository;

    public Mutation(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public Bike newBike(String name, String description, String owner){
        Bike bike = new Bike();
        bike.setName(name);
        bike.setDescription(description);
        bike.setOwner(owner);
        bikeRepository.save(bike);
        return bike;
    }

    public boolean deleteBike(Long id){
        bikeRepository.deleteById(id);
        return true;
    }

    public Bike updateBikeOwner(String newOwner, Long id) throws Exception {
        Optional<Bike> optionalBike = bikeRepository.findById(id);
        if(optionalBike.isPresent()){
            Bike bike = optionalBike.get();
            bike.setOwner(newOwner);
            bikeRepository.save(bike);
            return bike;
        } else {
            throw new BikeNotFoundException("Bike Not Found",id);
        }
    }
}
