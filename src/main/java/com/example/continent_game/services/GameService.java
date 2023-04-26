package com.example.continent_game.services;

import com.example.continent_game.models.Game;
import com.example.continent_game.models.Player;
import com.example.continent_game.repositories.GameRepository;
import com.example.continent_game.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    PlayerService playerService;
    @Autowired
    CountryService countryService;

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


//
//
//    @Service
//    public class GameService {
//
//        @Autowired
//        GameRepository gameRepository;
//        @Autowired
//        PlayerRepository playerRepository;
//
//        public List<Game> findAllGames(){
//            return gameRepository.findAll();
//        }
//
//        public Game findGame(Long id){
//            return gameRepository.findById(id).get();
//        }
//
//        public void saveGame(Game game){
//            gameRepository.save(game);
//        }
//
//        public void removeGameFromPlayers(Long id){
//            Game foundGame = gameRepository.getById(id);
//            for (Player player : foundGame.getPlayerList()) {
//                player.removeGame(foundGame);
//                playerRepository.save(player);
//            }
//            gameRepository.deleteById(id);
//        }
//
//        public void deleteGame(Long id){
//            gameRepository.deleteById(id);
//        }
//
//        public void updateGame(Game game, Long id){
//            Game gameToUpdate = gameRepository.findById(id).get();
//            gameToUpdate.setScore(game.getScore());
//            gameToUpdate.setComplete(game.isComplete());
//            gameToUpdate.setContinentList(game.getContinentList());
//            gameRepository.save(gameToUpdate);
//        }
//    }





}

