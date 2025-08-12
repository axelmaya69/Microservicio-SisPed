package com.microservicio_gateway;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    @Value('${jwt.secret}')
    private String secret;

    public boolean validateToken(String token) {
        try {

            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
