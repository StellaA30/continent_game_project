package com.example.continent_game.services;

import com.example.continent_game.models.Game;
import com.example.continent_game.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;

    //get all games
    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    // get game by ID
    public Optional<Game> getGameById(Long id){
        return gameRepository.findById(id);
    }

    //CREATE: Create/save a new game??
    // TODO: check if the update is related to the game logic??



    //UPDATE:  can we update a game -- ask Instructor??



    //  DELETE:
//  TODO: check if we need to remove player and continent before deleting game
    //delete game, logic might change will need to
    //delete continent object??
    //delete player object??
    public void deleteGame(Long id){
        gameRepository.deleteById(id);
    }

//    public void removePlayerAndContinentFromGame(Long id){
//        Player foundPlayer = playerRepository.getById(id);
//        for (Player player : foundEstate.getPlayers()) {
//            .removeEstate(foundEstate);
//    }





}
