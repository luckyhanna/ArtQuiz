package com.example.hannabotar.artquiz.domain;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by hanna.botar on 1/23/2018.
 */

public class Question implements Serializable {

    private int imageId;
    private String question;
    private Map<String, Boolean> answerMap;
    private String explanation;

    public Question() {
    }

    public Question(int imageId, String question, Map<String, Boolean> answerMap, String explanation) {
        this.imageId = imageId;
        this.question = question;
        this.answerMap = answerMap;
        this.explanation = explanation;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<String, Boolean> getAnswerMap() {
        return answerMap;
    }

    public void setAnswerMap(Map<String, Boolean> answerMap) {
        this.answerMap = answerMap;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
