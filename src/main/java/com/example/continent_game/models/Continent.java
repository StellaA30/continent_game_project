package com.example.continent_game.models;

import java.util.ArrayList;
import java.util.List;

public class Continent {

    private long id;
    private String name;
    private List<Country> countries;
    private List<Game> games;

    public Continent (String name) {
        this.name = name;
        this.countries = new ArrayList<>();
        this.games = new ArrayList<>();
    }

    public Continent(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
