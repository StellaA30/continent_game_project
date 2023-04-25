package com.example.continent_game.models;

import java.util.ArrayList;
import java.util.List;

public class ContinentDTO {
    private String name;
    private List<Long> countryIds;
    private List<Long> gameIds;
    public ContinentDTO (String name, List countryIds, List gameIds){
        this.name = name;
        this.countryIds = countryIds;
        this.gameIds = gameIds;
    }
    public ContinentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getCountryIds() {
        return countryIds;
    }

    public void setCountryIds(List<Long> countryIds) {
        this.countryIds = countryIds;
    }

    public List<Long> getGameIds() {
        return gameIds;
    }

    public void setGameIds(List<Long> gameIds) {
        this.gameIds = gameIds;
    }


}
