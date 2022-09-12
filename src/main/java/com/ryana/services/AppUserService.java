package com.ryana.services;

import com.ryana.domain.AppUser;
import com.ryana.domain.AuthorityScope;
import com.ryana.dto.AuthRequest;
import com.ryana.repositories.AppUserRepository;
import com.ryana.repositories.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public void save(AuthRequest authRequest) {
        Optional.ofNullable(authRequest)
                .map(this::createUser)
                .map(appUserRepository::save)
                .orElseThrow();
    }

    private AppUser createUser(AuthRequest request) {
        final var user = new AppUser();
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setAccountNonExpired(Boolean.TRUE);
        user.setAccountNonLocked(Boolean.TRUE);
        user.setCredentialsNonExpired(Boolean.TRUE);
        user.setEnabled(Boolean.TRUE);
        authorityRepository.findByAuthority(AuthorityScope.USER.name())
                .ifPresent(user.getAuthorities()::add);
        return user;
    }
}
