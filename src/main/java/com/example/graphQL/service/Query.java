package com.example.graphQL.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphQL.entity.Bike;
import com.example.graphQL.repository.BikeRepository;
import org.springframework.stereotype.Service;

@Service
public class Query implements GraphQLQueryResolver {

    private BikeRepository bikeRepository;

    public Query(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public Iterable<Bike> findAllBikes(){
        return bikeRepository.findAll();
    }

    public long countBikes(){
        return bikeRepository.count();
    }
}
