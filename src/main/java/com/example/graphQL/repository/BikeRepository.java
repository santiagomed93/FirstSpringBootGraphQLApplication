package com.example.graphQL.repository;

import com.example.graphQL.entity.Bike;
import org.springframework.data.repository.CrudRepository;

public interface BikeRepository extends CrudRepository<Bike, Long> {
}
