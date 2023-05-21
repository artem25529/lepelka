package com.es.lepelka.repository;

import com.es.lepelka.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findAllBySection(String section);

    List<Topic> findAllBySubsection(String section);

    List<Topic> findAllBySectionAndSubsection(String section, String subsection);
}
