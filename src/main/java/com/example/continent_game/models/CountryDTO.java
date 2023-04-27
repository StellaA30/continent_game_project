package com.example.continent_game.models;

import java.util.List;

public class CountryDTO {
    private String name;
    private long GDP;
    private String capital;
    private int population;
    private Long continentId;


    public CountryDTO(String name, long GDP, String capital, int population, Long continentId){
        this.name = name;
        this.GDP = GDP;
        this.capital = capital;
        this.population = population;
        this.continentId = continentId;
    }

    //Default constructor
    public CountryDTO(){

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

    public Long getContinentId() {
        return continentId;
    }

    public void setContinentId(Long continentId) {
        this.continentId = continentId;
    }
}
