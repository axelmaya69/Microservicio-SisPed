package com.microservicio_gateway.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
public class JwtAutenthication extends OncePerRequestFilter {

    private String secretKey;

    
}
