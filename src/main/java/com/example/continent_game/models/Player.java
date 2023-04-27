package com.example.continent_game.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "player")
    @JsonIgnoreProperties({"player", "continent", "guesses"})
    private List<Game> games;

    public Player (String name){
        this.name = name;
        this.games = new ArrayList<>();
    }

    public Player(){}
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

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }


//
//    @Entity
//    @Table(name = "players")
//    public class Player {
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        @Column
//        private Long id;
//        @Column
//        private String name;
//        @JsonIgnoreProperties({"players"})
//        @ManyToMany
//        @JoinTable(
//                name = "games_players",
//                joinColumns = @JoinColumn(name = "players_id"),
//                inverseJoinColumns = @JoinColumn(name = "game_id")
//        )
//        private List<Game> game;
//
//        public Player (String name){
//            this.name = name;
//            this.game = new ArrayList<>();
//        }
//        //    Methods
//        public void addGame(Game game){
//            this.game.add(game);
//        }
//
//        public void removeGame(Game game){
//            this.game.remove(game);
//        }
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
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public List<Game> getGame() {
//            return game;
//        }
//
//        public void setGame(List<Game> game) {
//            this.game = game;
//        }
//    }






}
