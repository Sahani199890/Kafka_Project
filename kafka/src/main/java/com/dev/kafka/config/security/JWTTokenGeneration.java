package com.dev.kafka.config.security;

import com.dev.kafka.entity.UsersEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Configuration;

import java.util.Map;


import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Configuration
public class JWTTokenGeneration {

    /**
     * IMPORTANT:
     * This MUST be Base64-encoded
     * Length >= 256 bits for HS256
     */
    private static final String SECRET_KEY = "MThiOGIwNmE1NDU4ZTg3MTI0MGZjNjYwZTJmYTM5OTc2Nzk4MDUwOWY5NDVjOGMxNTA3NGRkMzFkYTcwZjI0ZTI4ODgyMjY2OGRiN2EwNThjZjYzYTAzMzE0ODBjNzQ0MTZmNjI3ZjFhNDA4NjQxOGRiZmNhMWI2MDc2NWY1MjUzMGYxN2Q0MzZhZDc5NzJhOTQ5ZTVkZDFiZWIzNzV";

/* =======================
   Token generation
   ======================= */

    public String generateToken(String email) {
        return generateToken(Map.of(), email);
    }

    public String generateToken(Map<String, Object> extraClaims, String email) {
        return Jwts.builder()
                .subject(email)
                .issuer("Abhishek Sahani Developer")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 24h
                .claims(extraClaims) // merged safely
                .signWith(getSignInKey())
                .compact();
    }

/* =======================
   Token validation
   ======================= */

    public boolean isTokenValid(String token, UsersEntity user) {
        if (user == null || user.getEmail() == null) {
            return false;
        }

        final String email = extractEmail(token);
        return email.equals(user.getEmail()) && !isTokenExpired(token);
    }

/* =======================
   Claims extraction
   ======================= */

    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

/* =======================
   Signing key
   ======================= */

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
