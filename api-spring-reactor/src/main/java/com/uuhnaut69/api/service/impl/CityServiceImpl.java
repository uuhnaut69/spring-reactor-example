package com.uuhnaut69.api.service.impl;

import org.springframework.stereotype.Service;

import com.uuhnaut69.api.model.entity.City;
import com.uuhnaut69.api.repository.CityRepository;
import com.uuhnaut69.api.service.CityService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CityServiceImpl implements CityService {

	private final CityRepository cityRepository;

	public CityServiceImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public Flux<City> findAll() {
		return cityRepository.findAll();
	}

	@Override
	public Mono<City> findById(String id) {
		return cityRepository.findById(id);
	}

	@Override
	public Mono<City> addCity(Mono<City> city) {
		return city.flatMap(c -> {
			return cityRepository.save(c);
		});
	}

	@Override
	public Mono<Void> deleteCity(String id) {
		return cityRepository.deleteById(id);
	}

}
