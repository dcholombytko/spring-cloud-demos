package com.example.demo;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class GatewayConfiguration {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/name/male")
                        .filters(f -> f
                                .rewritePath("/name/(?<segment>.*)", "/${segment}/random")
                                .circuitBreaker(config -> config
                                        .setName("CircuitBreaker1")
                                        .setStatusCodes(Set.of("404", "500", "504"))
                                        .setFallbackUri("forward:/fallback/name/male"))
                        )
                        .uri("http://localhost:8090"))
                .route(r -> r.path("/name/female")
                        .filters(f -> f
                                .rewritePath("/name/(?<segment>.*)", "/${segment}/random")
                                .circuitBreaker(config -> config
                                        .setName("CircuitBreaker2")
                                        .setStatusCodes(Set.of("404", "500", "504"))
                                        .setFallbackUri("forward:/fallback/name/female"))
                        )
                        .uri("http://localhost:8090"))
                .route(r -> r.path("/lastname/male")
                        .filters(f -> f
                                .rewritePath("/lastname/(?<segment>.*)", "/${segment}/random")
                                .circuitBreaker(config -> config
                                        .setName("CircuitBreaker3")
                                        .setStatusCodes(Set.of("404", "500", "504"))
                                        .setFallbackUri("forward:/fallback/lastname/male"))
                        )
                        .uri("http://localhost:8091"))
                .route(r -> r.path("/lastname/female")
                        .filters(f -> f
                                .rewritePath("/lastname/(?<segment>.*)", "/${segment}/random")
                                .circuitBreaker(config -> config
                                        .setName("CircuitBreaker4")
                                        .setStatusCodes(Set.of("404", "500", "504"))
                                        .setFallbackUri("forward:/fallback/lastname/female"))
                        )
                        .uri("http://localhost:8091"))
                .build();
    }
}
