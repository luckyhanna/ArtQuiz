package com.example.hannabotar.artquiz.domain;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by hanna.botar on 1/23/2018.
 */

public class Result implements Serializable {

    private Question question;
    private Map<String, Boolean> answerMap;
    private boolean correct;


    public Result() {
    }

    public Result(Question question, Map<String, Boolean> answerMap, boolean correct) {
        this.question = question;
        this.answerMap = answerMap;
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Map<String, Boolean> getAnswerMap() {
        return answerMap;
    }

    public void setAnswerMap(Map<String, Boolean> answerMap) {
        this.answerMap = answerMap;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
