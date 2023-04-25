package com.example.continent_game.models;

import java.lang.ref.PhantomReference;

public class Country {

    private long id;
    private String name;
    private long GDP;
    private String capital;
    private int population;
    private Continent continent;


    public Country(String name, long GDP, String capital, int population, Continent continent){
        this.name = name;
        this.GDP = GDP;
        this.capital = capital;
        this.population = population;
        this.continent = continent;





    }

    public Country(){

    }

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

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}
