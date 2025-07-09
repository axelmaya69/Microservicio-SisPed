package com.microservicio_gateway.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class JwtAuthFilter  implements GlobalFilter {

    @Value("${jwt.secret}")
    private String secretKey;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getPath().toString();

        // Dejar pasar /auth/**
        if (path.startsWith("/auth")) {
            return chain.filter(exchange);
        }

    }
}

