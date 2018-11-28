package ru.mycrg.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingFiz {

    @Bean
    public RouteLocator hiRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/test")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://localhost:8010/test"))
                .build();
    }

    @Bean
    public RouteLocator testRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/oauth")
                        .filters(f -> f.addRequestParameter("redirect_uri", "http://localhost:8080/oauth"))
                        .uri("http://localhost:8010/oauth2/auth"))
                .build();
    }

    @Bean
    public RouteLocator strings(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/strings")
                        .uri("http://localhost:8090/strings"))
                .build();
    }

}
