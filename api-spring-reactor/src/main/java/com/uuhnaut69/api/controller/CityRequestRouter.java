package com.uuhnaut69.api.controller;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

@Configuration
public class CityRequestRouter {

	@Bean
	public RouterFunction<?> routes(CityRequestHandler requestHandler) {
		return route(GET("/cities/{id}").and(accept(APPLICATION_STREAM_JSON)), requestHandler::get)
				.andRoute(GET("/cities").and(accept(APPLICATION_STREAM_JSON)), requestHandler::getAll)
				.andRoute(DELETE("/cities/{id}"), requestHandler::delete)
				.andRoute(POST("/cities/add").and(accept(APPLICATION_STREAM_JSON)), requestHandler::post);
	}

}
