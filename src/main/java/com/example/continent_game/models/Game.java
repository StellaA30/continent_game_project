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


   @ManyToOne
   @JoinColumn(name = "continent_id", nullable = false)
    private Continent continent;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    //    create many to many (with country class) - game is the owner

    @JsonIgnoreProperties({"games"})
    @ManyToMany
    @JoinTable(name = "countries_games",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")




    )


    private List<Country> countries;
    private List<Country> guesses;

    private List<Guess> incorrectGuesses;

    private int penalty;

    //           guesses
    // game_id             country_id


    public Game (int score, boolean complete, Continent continent, Player player){
        this.score = score;
        this.complete = complete;
        this.continent = continent;
        this.player = player;
        this.countries = new ArrayList<>();
        this.guesses = new ArrayList<>();
        this.incorrectGuesses = new ArrayList<>();
        this.penalty = penalty;
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

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
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

    public List<Guess> getIncorrectGuesses() {
        return incorrectGuesses;
    }

    public void setIncorrectGuesses(List<Guess> incorrectGuesses) {
        this.incorrectGuesses = incorrectGuesses;
    }


    public void addGuessToIncorrectGuessesList(Guess guess) {
        this.incorrectGuesses.add(guess);
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

    //    maxscore
    public int maxScore(){
        return this.continent.getCountries().size();
    }



//
//    @Entity
//    @Table(name = "games")
//    public class Game {
//        @Id
//        @GeneratedValue (strategy = GenerationType.IDENTITY)
//        @Column
//        private Long id;
//        @Column
//        private int score;
//        @Column
//        private boolean complete;
//
//        @OneToMany(mappedBy = "game")
//        @JsonIgnoreProperties({"game"})
//        private List<Continent> continentList;
//        @JsonIgnoreProperties({"games"})
//        @ManyToMany(mappedBy = "games")
//        private List<Player> playerList;
//
//        public Game (int score, boolean complete){
//            this.score = score;
//            this.complete = complete;
//            this.continentList = new ArrayList<>();
//            this.playerList = new ArrayList<>();
//        }
////    Methods
//
//
////    Getters/Setters
//
//
//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
//
//        public int getScore() {
//            return score;
//        }
//
//        public void setScore(int score) {
//            this.score = score;
//        }
//
//        public boolean isComplete() {
//            return complete;
//        }
//
//        public void setComplete(boolean complete) {
//            this.complete = complete;
//        }
//
//        public List<Continent> getContinentList() {
//            return continentList;
//        }
//
//        public void setContinentList(List<Continent> continentList) {
//            this.continentList = continentList;
//        }
//
//        public List<Player> getPlayerList() {
//            return playerList;
//        }
//
//        public void setPlayerList(List<Player> playerList) {
//            this.playerList = playerList;
//        }
//
//


}
