package com.ryana.services;

import com.ryana.domain.AppUser;
import com.ryana.domain.Authority;
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
        return AppUser.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .accountNonExpired(Boolean.TRUE)
                .accountNonLocked(Boolean.TRUE)
                .credentialsNonExpired(Boolean.TRUE)
                .enabled(Boolean.TRUE)
                .authority(findByAuthorityUSER())
                .build();
    }

    private Authority findByAuthorityUSER() {
        return authorityRepository.findByAuthority(AuthorityScope.USER.name())
                .orElse(null);
    }
}
