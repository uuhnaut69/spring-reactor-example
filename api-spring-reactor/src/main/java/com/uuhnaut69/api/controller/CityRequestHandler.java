package com.uuhnaut69.api.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.uuhnaut69.api.model.entity.City;
import com.uuhnaut69.api.service.CityService;

import reactor.core.publisher.Mono;

@Component
public class CityRequestHandler {

	private final CityService cityService;

	public CityRequestHandler(CityService cityService) {
		this.cityService = cityService;
	}

	public Mono<ServerResponse> get(ServerRequest request) {
		String id = request.pathVariable("id");
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(cityService.findById(id), City.class)
				.switchIfEmpty(ServerResponse.notFound().build());
	}

	public Mono<ServerResponse> getAll(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(cityService.findAll(), City.class)
				.switchIfEmpty(ServerResponse.notFound().build());
	}

	public Mono<ServerResponse> post(ServerRequest request) {
		Mono<City> city = request.bodyToMono(City.class);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(cityService.addCity(city), City.class);
	}

	public Mono<ServerResponse> delete(ServerRequest request) {
		String id = request.pathVariable("id");
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(cityService.deleteCity(id), Void.class);
	}
}
