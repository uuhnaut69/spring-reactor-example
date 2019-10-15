package com.uuhnaut69.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.uuhnaut69.api.model.entity.City;

@Repository
public interface CityRepository extends ReactiveMongoRepository<City, String> {

}
