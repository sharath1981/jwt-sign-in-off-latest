package com.ryana.repositories;

import com.ryana.domain.Authority;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    @EntityGraph(attributePaths = {"users"})
    Optional<Authority> findByAuthority(String authority);
}