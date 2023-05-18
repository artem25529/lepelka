package com.es.lepelka.repository;

import com.es.lepelka.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
