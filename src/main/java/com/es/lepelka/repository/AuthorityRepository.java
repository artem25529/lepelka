package com.es.lepelka.repository;

import com.es.lepelka.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Optional<Authority> findAuthorityByAuthority(String authority);
}
