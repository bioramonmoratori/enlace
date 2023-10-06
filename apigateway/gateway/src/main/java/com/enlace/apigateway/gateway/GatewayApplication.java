package com.enlace.apigateway.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("usuario_route", r -> r
				.path("/api/**")
				.uri("lb://api"))
			.route("produto_route", r -> r
            	.path("/instaapi/**")
            	.uri("lb://instaapi")) // Use o nome do serviço registrado no Eureka
			.build();
	}

}
