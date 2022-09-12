package com.ryana.controllers;

import com.ryana.dto.AuthRequest;
import com.ryana.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class SignUpController {
    private final AppUserService appUserService;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody AuthRequest authRequest) {
        Optional.ofNullable(authRequest).ifPresent(appUserService::save);
    }
}
