package com.example.continent_game.models;

public class Guess {
    private String countryName;

    public Guess (String countryName){
        this.countryName = countryName;
    }
    public Guess(){

    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
