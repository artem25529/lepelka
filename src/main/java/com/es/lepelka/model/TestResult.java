package com.es.lepelka.model;

import java.util.List;

public class TestResult {
    private int questionsQty;
    private int correctAnswersQty;

    private List<QuestionResult> questionErrors;

    public TestResult(int questionsQty, int correctAnswersQty) {
        this.questionsQty = questionsQty;
        this.correctAnswersQty = correctAnswersQty;
    }

    public TestResult(int questionsQty, int correctAnswersQty, List<QuestionResult> questionErrors) {
        this.questionsQty = questionsQty;
        this.correctAnswersQty = correctAnswersQty;
        this.questionErrors = questionErrors;
    }

    public int getQuestionsQty() {
        return questionsQty;
    }

    public void setQuestionsQty(int questionsQty) {
        this.questionsQty = questionsQty;
    }

    public int getCorrectAnswersQty() {
        return correctAnswersQty;
    }

    public void setCorrectAnswersQty(int correctAnswersQty) {
        this.correctAnswersQty = correctAnswersQty;
    }

    public List<QuestionResult> getQuestionErrors() {
        return questionErrors;
    }

    public void setQuestionErrors(List<QuestionResult> questionErrors) {
        this.questionErrors = questionErrors;
    }
}
