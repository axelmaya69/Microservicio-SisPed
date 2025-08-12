package com.microservicio_gateway;

public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;

    public boolean validateToken(String token) {
        try {
}
