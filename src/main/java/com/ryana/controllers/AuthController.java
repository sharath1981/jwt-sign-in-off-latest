package com.ryana.controllers;

import com.ryana.services.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Log4j2
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final TokenService tokenService;

    @PostMapping("/token")
    public String token(Authentication authentication, HttpServletResponse response) {
        log.debug("Token requested for user: '{}'", authentication.getName());
        final var token = tokenService.generateToken(authentication);
        log.debug("Token granted: {}", token);
        response.addHeader("Authorization", String.format("Bearer %s", token));
        return token;
    }

}
