package com.example.continent_game.models;

import java.util.ArrayList;
import java.util.List;

public class Country {
    private Long id;
    private String name;
    private long GDP;
    private String capital;
    private int population;
    private List<Continent> continent;

    public Country(String name, long GDP, String capital, int population){
        this.name = name;
        this.GDP = GDP;
        this.capital = capital;
        this.population = population;
        this.continent = new ArrayList<>();
    }
    public Country(){

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

    public long getGDP() {
        return GDP;
    }

    public void setGDP(long GDP) {
        this.GDP = GDP;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<Continent> getContinent() {
        return continent;
    }

    public void setContinent(List<Continent> continent) {
        this.continent = continent;
    }
}
