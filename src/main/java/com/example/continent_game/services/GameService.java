package com.example.continent_game.services;

import com.example.continent_game.models.*;
import com.example.continent_game.repositories.GameRepository;
import com.example.continent_game.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private String currentWord;
    //    Array of player's guesses
    private ArrayList<Country> guessedCountryList;
    //    Total countries within a given continent
    private ArrayList<Country> totalCountryList;

    public GameService (){

    }

    public String getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public ArrayList<Country> getGuessedCountryList() {
        return guessedCountryList;
    }

    public void setGuessedCountryList(ArrayList<Country> guessedCountryList) {
        this.guessedCountryList = guessedCountryList;
    }

    public ArrayList<Country> getTotalCountryList() {
        return totalCountryList;
    }

    public void setTotalCountryList(ArrayList<Country> totalCountryList) {
        this.totalCountryList = totalCountryList;
    }



    public Reply processGuess(Guess guess, Long id){
//        find correct game
        Game game = gameRepository.findById(id).get();
//        Check if game is already completed
        if (game.isComplete()){
            return new Reply(
                    false,
                    getCurrentWord(),
                    guessedCountryList.size() + "/"+totalCountryList.size(),
                    String.format("Already finished game %d", game.getId())
            );
        }
//        Check if country has been guessed already
        if(this.guessedCountryList.contains(guess.getCountryName())){
            return new Reply(false, this.currentWord, guessedCountryList.size() + "/"+totalCountryList.size(),String.format("Already guessed %s", guess.getCountryName()));
        }
    }


    private void addToGuessedCountryList(){
//        add guess to the total country list if guess is contained in the totalCountryList
        Guess guess = new Guess();
        if(totalCountryList.contains(guess)){
//            find id of country indicated by guess
//            add country located by id to guessedCountryList
            guessedCountryList.add();

        }
    }





























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
    public void updateGame(Game game, Long id){
            Game gameToUpdate = gameRepository.findById(id).get();
            gameToUpdate.setScore(game.getScore());
            gameToUpdate.setComplete(game.isComplete());
            gameToUpdate.setContinent(game.getContinent());
            gameToUpdate.setPlayer(game.getPlayer());
            gameRepository.save(gameToUpdate);
        }



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

