package com.es.lepelka.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Test")
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String section;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    private List<Question> questions;

    public Test() {
    }

    public Test(String section, String name, List<Question> questions) {
        this.section = section;
        this.name = name;
        this.questions = questions;
    }

    public Test(String section, String name) {
        this.section = section;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
