package com.example.hannabotar.artquiz.domain;

import java.io.Serializable;

/**
 * Created by hanna.botar on 1/23/2018.
 */

public class Result implements Serializable {

    private Question question;
    private String answer;
    private boolean correct;

    public Result() {
    }

    public Result(Question question, String answer, boolean correct) {
        this.question = question;
        this.answer = answer;
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
