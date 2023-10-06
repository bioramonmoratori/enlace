package com.enlace.apigateway.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	private static final String[] AUTH_WHITELIST = {
        // -- Swagger UI v2
        "/v2/api-docs",
        "/swagger-resources",
        "/swagger-resources/**",
        "/configuration/ui",
        "/configuration/security",
        "/swagger-ui.html",
        "/webjars/**",
        // -- Swagger UI v3 (OpenAPI)
        "/v3/api-docs/**",
        "/swagger-ui/**"
        // other public endpoints of your API may be appended to this array
    };

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("usuario_route", r -> r
				.path("/api/**")
				.uri("lb://api"))
			.route("usuario_route", r -> r
				.path("/actuator/**")
				.uri("lb://api"))
				.route("usuario_route", r -> r
				.path(AUTH_WHITELIST)
				.uri("lb://api"))
			.route("produto_route", r -> r
            	.path("/instaapi/**")
            	.uri("lb://instaapi")) // Use o nome do serviço registrado no Eureka
			.build();
	}

}
