package com.demo.wel.security;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private final Map<String, User> users = new ConcurrentHashMap<>(Map.ofEntries(
            Map.entry("apiuser", new User("apiuser", "password123", Set.of("API_USER"))),
            Map.entry("uiuser", new User("uiuser", "password123", Set.of("UI_USER")))
    ));

    public User validateUser(String username, String password) {
        log.debug("Validating user: {}", username);
        User user = users.get(username);
        return (user != null && user.getPassword().equals(password)) ? user : null;
    }
}
