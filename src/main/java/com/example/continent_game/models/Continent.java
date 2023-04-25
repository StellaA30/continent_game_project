package com.example.continent_game.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "continents")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @JsonIgnoreProperties({"continent"})
    @OneToMany(mappedBy = "continent")
    private List<Country> countries;

//    TODO: JOIN
    @Column(name="games")
    private List<Game> gameList;

    public Continent (String name){
        this.name = name;
        this.countries = new ArrayList<>();
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

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}
