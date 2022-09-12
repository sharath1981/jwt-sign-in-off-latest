package com.ryana.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TokenService {
    public static final String SELF = "self";
    public static final String SCOPE = "scope";
    private final JwtEncoder jwtEncoder;

    public String generateToken(Authentication authentication) {
        return jwtEncoder.encode(JwtEncoderParameters.from(getClaims(authentication)))
                .getTokenValue();
    }

    private JwtClaimsSet getClaims(Authentication authentication) {
        final var now = Instant.now();
        return JwtClaimsSet.builder()
                .issuer(SELF)
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(authentication.getName())
                .claim(SCOPE, getScope(authentication))
                .build();
    }

    private String getScope(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
    }
}
