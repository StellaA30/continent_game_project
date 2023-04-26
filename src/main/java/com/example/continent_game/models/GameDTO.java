package com.example.continent_game.models;

import java.util.List;

public class GameDTO {
    private int score;
    private boolean complete;
    private List<Long> continentIds;
    private List<Long> playerIds;


    public GameDTO (int score, boolean complete, List continentIds, List playerIds){
        this.score = score;
        this.complete = complete;
        this.continentIds = continentIds;
        this.playerIds = playerIds;
    }

    public GameDTO(){
        //default constructor
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public List<Long> getContinentIds() {
        return continentIds;
    }

    public void setContinentIds(List<Long> continentIds) {
        this.continentIds = continentIds;
    }

    public List<Long> getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(List<Long> playerIds) {
        this.playerIds = playerIds;
    }
}
