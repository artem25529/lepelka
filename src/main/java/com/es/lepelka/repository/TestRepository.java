package com.es.lepelka.repository;

import com.es.lepelka.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestRepository extends JpaRepository<Test, Long> {
    Optional<Test> findTestBySection(String section);

    Optional<Test> findTestByName(String name);

    List<Test> findAllBySection(String section);
}
