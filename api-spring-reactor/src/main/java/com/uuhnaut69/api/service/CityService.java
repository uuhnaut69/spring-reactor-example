package com.uuhnaut69.api.service;

import com.uuhnaut69.api.model.entity.City;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CityService {

	Flux<City> findAll();

	Mono<City> findById(String id);

	Mono<City> addCity(Mono<City> city);

	Mono<Void> deleteCity(String id);

}
