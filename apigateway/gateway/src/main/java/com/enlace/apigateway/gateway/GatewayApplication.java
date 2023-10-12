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
            .route("api-route", r -> r
                .path("/v3/api-docs/api/**", "/api/swagger-ui/**")
                .uri("lb://api"))
            .route("instaapi-route", r -> r
                .path("/v3/api-docs/instaapi/**", "/instaapi/swagger-ui/**")
                .uri("lb://instaapi"))
            .route("combined-swagger-route", r -> r
                .path("/v3/api-docs/combined", "/combined/swagger-ui/**")
                .uri("lb://api")) // Pode ser qualquer serviço, pois não importa
            .build();
    }
	

}
