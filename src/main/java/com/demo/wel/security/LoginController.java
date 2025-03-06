package com.demo.wel.security;

import com.demo.wel.util.ErrorCode;
import com.demo.wel.util.FunctionalException;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final JwtUtil jwtUtil;
    private final UserService userService;

    @PostMapping("api/login")
    public Map<String, String> login(@RequestBody User user) {
        User validUser = userService.validateUser(user.getUsername(), user.getPassword());
        if (validUser == null) {
            throw new FunctionalException(ErrorCode.ACCESS_DENIED, "Invalid Credentials", HttpStatus.FORBIDDEN);
        }

        String accessToken = jwtUtil.generateToken(user.getUsername(), validUser.getRoles(), false);
        String refreshToken = jwtUtil.generateToken(user.getUsername(), validUser.getRoles(), true);
        return Map.of("accessToken", accessToken, "refreshToken", refreshToken);
    }
}
