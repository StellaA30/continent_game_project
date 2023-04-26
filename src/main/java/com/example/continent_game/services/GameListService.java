package com.example.continent_game.services;

import com.example.continent_game.models.Continent;
import com.example.continent_game.repositories.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameListService {

    @Autowired
    ContinentRepository continentRepository;
    //get a random continent from the list of continents
    public Continent getRandomContinent(){
        Random randomId = new Random();
        Long random = randomId.nextLong(1, 7);
        return continentRepository.findById(random).get();
    }
}
