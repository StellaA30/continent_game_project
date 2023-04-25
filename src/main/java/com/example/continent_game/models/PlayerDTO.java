package com.example.continent_game.models;

import java.util.List;

public class PlayerDTO {
    private String name;
    private List<Long> gameIds;

    public PlayerDTO(String name, List<Long> gameIds){
        this.name = name;
        this.gameIds = gameIds;
    }
    public PlayerDTO (){

    }


//    Getters/Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getGameIds() {
        return gameIds;
    }

    public void setGameIds(List<Long> gameIds) {
        this.gameIds = gameIds;
    }
}


