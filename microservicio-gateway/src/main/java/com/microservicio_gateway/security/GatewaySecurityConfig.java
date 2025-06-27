package com.microservicio_gateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.net.URI;

@Configuration
@EnableWebFluxSecurity
public class GatewaySecurityConfig {
 
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/login", "/").permitAll()
                        .anyExchange().authenticated()
                )
                .logout(logout -> logout
                        .logoutSuccessHandler((exchange, authentication) -> {
                            exchange.getExchange().getResponse()
                                    .setStatusCode(HttpStatus.FOUND);
                            exchange.getExchange().getResponse().getHeaders()
                                    .setLocation(URI.create("/inicio"));
                            return exchange.getExchange().getResponse().setComplete();
                        })
                )
                .oauth2Login(Customizer.withDefaults()) // reactivo
                .build();
    }
}