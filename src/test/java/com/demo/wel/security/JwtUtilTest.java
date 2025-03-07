package com.demo.wel.security;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.Test;

class JwtUtilTest {

    JwtUtil jwtUtil = new JwtUtil();

    @Test
    void generateToken() {
        String token = jwtUtil.generateToken("username", Set.of("ROLE1", "ROLE2"), false);

        assertThat(jwtUtil.isTokenValid(token)).isTrue();
        assertThat(jwtUtil.extractUsername(token)).isEqualTo("username");
        assertThat(jwtUtil.extractRoles(token)).containsExactlyInAnyOrder("ROLE1", "ROLE2");
    }
}