package com.apiGateway.config;

// import org.springframework.cloud.gateway.route.RouteLocator;
// import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class GatewayConfig {
// 	@Bean
// 	public RouteLocator routes(RouteLocatorBuilder builder) {
// 		return builder.routes()
// 				.route("user-services", r -> r.path("/api/users/**")
// 						.uri("lb://USER-SERVICE"))
// 				.route("product-service", r -> r.path("/api/products/**")
// 						.uri("lb://PRODUCT-SERVICE"))
// 				.build();
// 	}
// }	


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("secured-product-service", r -> r.path("/secure/products/**")
                .filters(f -> f.addRequestHeader("Authorization", "Bearer xyz"))
                .uri("lb://PRODUCT-SERVICE"))
            .route("order-service-with-logging", r -> r.path("/secure/orders/**")
                .filters(f -> f.addResponseHeader("X-Gateway-Message", "Handled by Gateway"))
                .uri("lb://ORDER-SERVICE"))
            .build();
    }
}
