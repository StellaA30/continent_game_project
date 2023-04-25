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
    @JsonIgnoreProperties({"chocolates"})
    private List<Continent> continentList;
    @JsonIgnoreProperties({"chocolates"})
    @ManyToMany
    @JoinTable(
            name = "chocolates_estates",
            joinColumns = @JoinColumn(name = "chocolate_id"),
            inverseJoinColumns = @JoinColumn(name = "estate_id")
    )
    private List<Player> playerList;

    public Game (int score, boolean complete){
        this.score = score;
        this.complete = complete;
        this.continentList = new ArrayList<>();
        this.playerList = new ArrayList<>();
    }
//    Methods


//    Getters/Setters


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

    public List<Continent> getContinentList() {
        return continentList;
    }

    public void setContinentList(List<Continent> continentList) {
        this.continentList = continentList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
//    khsguyhgs




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
