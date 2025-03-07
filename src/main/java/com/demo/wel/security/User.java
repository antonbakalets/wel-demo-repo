package com.demo.wel.security;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

    private String username;

    private String password;

    @Schema(hidden = true)
    private Set<String> roles;
}
