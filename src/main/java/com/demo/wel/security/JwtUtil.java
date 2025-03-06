package com.demo.wel.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import java.util.Date;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private static final long ACCESS_TOKEN_VALIDITY = 15 * 60 * 1000; // 15 minutes
    private static final long REFRESH_TOKEN_VALIDITY = 60 * 60 * 1000; // 1 hour

    private final SecretKey secretKey = Jwts.SIG.HS256.key().build();

    public String generateToken(String username, Set<String> roles, boolean isRefresh) {
        long validity = isRefresh ? REFRESH_TOKEN_VALIDITY : ACCESS_TOKEN_VALIDITY;
        return Jwts.builder()
                .subject(username)
                .claim("roles", String.join(",", roles))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + validity))
                .signWith(secretKey)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String[] extractRoles(String token) {
        String roles = extractClaim(token, claims -> claims.get("roles", String.class));
        return roles.split(",");
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        JwtParser parser = Jwts.parser().verifyWith(secretKey).build();
        Claims claims = parser.parseSignedClaims(token).getPayload();
        return claimsResolver.apply(claims);
    }

    public boolean isTokenValid(String token) {
        return !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
}
