package com.example.continent_game.models;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    private Long id;
    private String name;
    private List<Country> countryList;
    private List<Game> gameList;
    public Continent (String name){
        this.name = name;
        this.countryList = new ArrayList<>();
        this.gameList = new ArrayList<>();
    }
    public Continent(){

    }
//    Methods


//    Getters/Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}
