package com.demo.wel.security;

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

    private Set<String> roles;
}
