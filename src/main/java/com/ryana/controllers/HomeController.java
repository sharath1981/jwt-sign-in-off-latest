package com.ryana.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HomeController {
    @GetMapping
    public String home(Authentication authentication) {
        return String.format("Any logged in user can access.. {%s}", authentication.getName());
    }

    @GetMapping("admin")
    public String admin(Authentication authentication) {
        return String.format("Any logged in user having authority ADMIN can access.. {%s}", authentication.getName());
    }

    @GetMapping("user")
    public String user(Authentication authentication) {
        return String.format("Any logged in user having authority USER or ADMIN can access.. {%s}", authentication.getName());
    }

    //@PreAuthorize("hasAnyAuthority('SCOPE_ADMIN')")
    @Secured({"ADMIN"})
    @GetMapping("preAdmin")
    public String preAdmin(Authentication authentication) {
        return String.format("Any logged in user having authority ADMIN can access.. {%s}", authentication.getName());
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_USER', 'SCOPE_ADMIN')")
    //@Secured({"ADMIN", "USER"})
    @GetMapping("preUser")
    public String preUser(Authentication authentication) {
        return String.format("Any logged in user having authority USER or ADMIN can access.. {%s}", authentication.getName());
    }
}

