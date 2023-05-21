package com.es.lepelka.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Question")
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String question;

    @Column(name = "right_answer")
    private int rightAnswer;

    @ElementCollection
    @CollectionTable(name = "response_varians", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "variant")
    private List<String> variants;

    public Question() {
    }

    public Question(String question, int rightAnswer) {
        this.question = question;
        this.rightAnswer = rightAnswer;
    }

    public Question(String question, int rightAnswer, List<String> variants) {
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.variants = variants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public List<String> getVariants() {
        return variants;
    }

    public void setVariants(List<String> variants) {
        this.variants = variants;
    }
}
