package com.microservicio_gateway;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.function.HandlerFilterFunction;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class GatewayRoutesConfig {

    private final JwtUtil jwtUtil;

    public GatewayRoutesConfig(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public RouterFunction<ServerResponse> routes() {
        HandlerFilterFunction<ServerResponse, ServerResponse> jwtFilter = (request, next) -> {
            String authHeader = request.headers().firstHeader(HttpHeaders.AUTHORIZATION);
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return ServerResponse.status(HttpStatus.UNAUTHORIZED).build();
            }
            String token = authHeader.substring(7);
            if (!jwtUtil.validateToken(token)) {
                return ServerResponse.status(HttpStatus.UNAUTHORIZED).build();
            }
            return next.handle(request);
        };

        RouterFunction<ServerResponse> publicRoutes = GatewayRouterFunctions.route()
            .route(RequestPredicates.path("/auth/**"), HandlerFunctions.http("http://localhost:9093"))
            .build();

        RouterFunction<ServerResponse> protectedRoutes = GatewayRouterFunctions.route()
            .filter(jwtFilter)
            .route(RequestPredicates.path("/api/cliente/**"),          HandlerFunctions.http("http://localhost:9090"))
            .route(RequestPredicates.path("/api/producto/**"),         HandlerFunctions.http("http://localhost:9091"))
            .route(RequestPredicates.path("/api/pedido/**")
                .or(RequestPredicates.path("/api/pedidoproducto/**")), HandlerFunctions.http("http://localhost:9092"))
            .build();

        return publicRoutes.and(protectedRoutes);
    }
}
