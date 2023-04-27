package com.example.continent_game.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private int score;

    @Column
    private boolean complete;

    @JsonIgnoreProperties({"games", "countries"})
    @ManyToOne
    @JoinColumn(name = "continent_id", nullable = false)
    private Continent continent;

    @JsonIgnoreProperties({"games"})
    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @JsonIgnoreProperties({"games", "continent"})
    @ManyToMany
    @JoinTable(name = "guesses",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private List<Country> guesses;

    @Column
    private int penalty;


// Constructor
    public Game (Continent continent, Player player){
        this.score = 0;
        this.complete = false;
        this.continent = continent;
        this.player = player;
        this.guesses = new ArrayList<>();
//        this.incorrectGuesses = new ArrayList<>();
        this.penalty = 0;
    }


    //Default constructor
    public Game(){

    }



//    Getters/Setters


    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }



    public List<Country> getGuesses() {
        return guesses;
    }

    public void setGuesses(List<Country> guesses) {
        this.guesses = guesses;
    }

    public void addGuessToGuessesList(Country guess){
        this.guesses.add(guess);
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    //    get countries for game
    public List<Country> getCountriesForGame(){
        return this.continent.getCountries();
    }

//  MaxScore
    public int maxScore(){
        return this.continent.getCountries().size();
    }


}
