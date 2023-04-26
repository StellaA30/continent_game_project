package com.example.continent_game.models;

public class Reply {

    private int currentScore;
    private int maxScore;
    private int penalty;
    private String message;


    public Reply(int currentScore, int maxScore, int penalty, String message) {
        this.currentScore = currentScore;
        this.maxScore = maxScore;
        this.penalty = penalty;
        this.message = message;
    }


    public Reply() {
        //default constructor
    }


//    Getters & Setters
    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

