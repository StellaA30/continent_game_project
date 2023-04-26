package com.example.continent_game.models;

public class Reply {
    private boolean correct;
    private String countState; //displays the {correct}/{total_countries}
    private String message;

    public Reply(boolean correct, String countState, String message) {
        this.correct = correct;
        this.countState = countState;
        this.message = message;
    }

    public Reply() {
        //default constructor
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getCountState() {
        return countState;
    }

    public void setCountState(String countState) {
        this.countState = countState;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
