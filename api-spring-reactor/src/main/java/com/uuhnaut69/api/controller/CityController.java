package com.uuhnaut69.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uuhnaut69.api.model.entity.City;
import com.uuhnaut69.api.service.CityService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/v1/api/cities", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

	private final CityService cityService;

	public CityController(CityService cityService) {
		this.cityService = cityService;
	}

	@GetMapping
	public Flux<City> findAll() {
		return cityService.findAll();
	}

	@GetMapping("/{id}")
	public Mono<City> findById(@PathVariable String id) {
		return cityService.findById(id);
	}

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<City> addCity(@RequestBody City city) {
		return cityService.addCity(city);
	}

	@DeleteMapping("/id")
	public Mono<Void> deleteCity(@PathVariable String id) {
		return cityService.deleteCity(id);
	}

}
