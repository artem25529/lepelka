package com.es.lepelka.model;

public class QuestionResult {
    private int questionNumber;
    private int rightAnswer;
    private int actualAnswer;

    public QuestionResult(int questionNumber, int rightAnswer, int actualAnswer) {
        this.questionNumber = questionNumber;
        this.rightAnswer = rightAnswer;
        this.actualAnswer = actualAnswer;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public int getActualAnswer() {
        return actualAnswer;
    }

    public void setActualAnswer(int actualAnswer) {
        this.actualAnswer = actualAnswer;
    }
}
