package com.example.continent_game.services;

import com.example.continent_game.models.*;
import com.example.continent_game.repositories.CountryRepository;
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

    @Autowired
    CountryRepository countryRepository;





////    //    Array of player's guesses
//    private ArrayList<Country> guessedCountryList;
//    //    Total countries within a given continent
//    private ArrayList<Country> totalCountryList;

    public GameService (){

    }



    public Reply processGuess(Guess guess, Long id) {
//        Find correct game
// Add correct guess to guessedCountryList and increments score by 1 for each correct guess
// - this is also used when getting the score (size of list)
        Game game = gameRepository.findById(id).get();
        //countryrepo derived query, full country object easier to compare to than just their name
        Country guessedCountry = countryRepository.findCountryByNameIgnoreCase(guess.getCountryName());

        //notification for user saying we've already guessed it, pass as String
        if (game.getGuesses().contains(guessedCountry)) {
            return new Reply();
        }
        if (game.getCountriesForGame().contains(guessedCountry)) {
            game.addGuessToGuessesList(guessedCountry);
            game.setScore(game.getScore() + 1);
            //check if game.getScore() = game.getCountries.size
            if (game.getScore() == game.maxScore()) {
                game.setComplete(true);
                gameRepository.save(game);
                return new Reply();//(>^_^)>
            }
            gameRepository.save(game);//update guess and list
            return new Reply();
        }
        game.addGuessToGuessesList(guessedCountry);
        game.setPenalty(game.getPenalty() + 1);
        if (game.getPenalty() == 5) {
            game.setComplete(true);
            gameRepository.save(game);
            return new Reply();//Q_____Q
        }
        gameRepository.save(game);
        return new Reply();
        //eg. you could prompt them how many correct guesses are left, or how many chances you have left
    }

    //find the country by the name
    //game.getCountries().contains(foundCountry)
    //game.getGuesses()
//
//        Game game = gameRepository.findById(id).get();

////        Check if game is already completed
//        if (game.isComplete()){
//            return new Reply(
//                    false,
//                    getCurrentWord(),
//                    guessedCountryList.size() + "/" + totalCountryList.size(),
//                    String.format("Already finished game %d", game.getId())
//            );
//        }
////        Check if country has been guessed already
//        if(this.guessedCountryList.contains(guess.getCountryName())){
//            return new Reply(false, this.currentWord, guessedCountryList.size() + "/"+totalCountryList.size(),String.format("Already guessed %s", guess.getCountryName()));
//        }





//        Handle correct guess




//        Check for win
//             finalScore - update score property in the game that's being/been played











//    private void addGuessToGuessesList(Guess guess, Long id){
//        Game game = gameRepository.findById(id).get();
//        for(Country countryInTheGame : game.getCountriesForGame()){
//            if(guess.getCountryName().toLowerCase().equals(countryInTheGame.getName().toLowerCase())) {
//                game.addGuessToGuessesList(countryInTheGame);
//                game.setScore(game.getScore() + 1);
//            }   else {
//                game.addGuessToIncorrectGuessesList(guess);
//                game.setPenalty(game.getPenalty() + 1);
//            }
//        }
//    }



// TODO: add in feature to logic if we have time - if they add three wrong guesses in total (not necessarily in a row), end game



























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

