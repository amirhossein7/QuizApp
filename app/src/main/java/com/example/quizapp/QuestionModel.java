package com.example.quizapp;

public class QuestionModel {

    private String question;
    private Boolean answer;

    public QuestionModel(String question, Boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public Boolean getAnswer() {
        return answer;
    }
}
