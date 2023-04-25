package com.example.continent_game.models;

import java.util.LinkedList;

public class Player {
    private Long id;
    private String name;
    private LinkedList<Game> gameLinkedList;

    public Player (String name){
        this.name = name;
        this.gameLinkedList = new LinkedList<>();
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

    public LinkedList<Game> getGameLinkedList() {
        return gameLinkedList;
    }

    public void setGameLinkedList(LinkedList<Game> gameLinkedList) {
        this.gameLinkedList = gameLinkedList;
    }
}
