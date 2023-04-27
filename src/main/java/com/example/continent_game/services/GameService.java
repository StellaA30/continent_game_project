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
    GameListService gameListService;

    @Autowired
    CountryRepository countryRepository;


    public GameService (){

    }


    public Reply processGuess(Guess guess, Long id) {
//        Find correct game
        Game game = gameRepository.findById(id).get();
        //countryrepo derived query, full country object easier to compare to than just their name
        Country guessedCountry = countryRepository.findCountryByNameIgnoreCase(guess.getCountryName());

        //notification for user saying we've already guessed it, pass as String
        if (game.getGuesses().contains(guessedCountry)) {
            return new Reply(game.getScore(), game.maxScore(), game.getPenalty(), "You've already guessed " + guessedCountry.getName() + ". Have another go!");
        }
        if (game.getCountriesForGame().contains(guessedCountry)) {
            game.addGuessToGuessesList(guessedCountry);
            game.setScore(game.getScore() + 1);
            //check if game.getScore() = game.getCountries.size
            if (game.getScore() == game.maxScore()) {
                game.setComplete(true);
                gameRepository.save(game);
                return new Reply(game.getScore(), game.maxScore(), game.getPenalty(), "You've found all the countries in " + guessedCountry.getContinent().getName() + "! (>^_^)>");//(>^_^)>
            }
            gameRepository.save(game);//update guess and list
            return new Reply(game.getScore(), game.maxScore(), game.getPenalty(), "Correct! " + guessedCountry.getName() + " is a country in " + guessedCountry.getContinent().getName() + ". Can you guess any more?");
        }
        game.addGuessToGuessesList(guessedCountry);
        game.setPenalty(game.getPenalty() + 1);
        if (game.getPenalty() == 5) {
            game.setComplete(true);
            gameRepository.save(game);
            return new Reply(game.getScore(), game.maxScore(), game.getPenalty(), "Incorrect, game over. You've reached the maximum number of penalties. Your final score was " + game.getScore() + ".");//Q_____Q
        }
        gameRepository.save(game);
        return new Reply(game.getScore(), game.maxScore(), game.getPenalty(), "Incorrect. " + guessedCountry.getName() + " is not in " + game.getContinent().getName() + ". You have " + String.valueOf(5 - game.getPenalty()) + " chances left.");
        //eg. you could prompt them how many correct guesses are left, or how many chances you have left
    }

    public Reply terminateGame(Long id){
        Game game = gameRepository.findById(id).get();
        game.setComplete(true);
        gameRepository.save(game);
        return new Reply(game.getScore(), game.maxScore(), game.getPenalty(), "Game ended. You scored " + game.getScore() + " out of " + game.maxScore() + ".");
    }

    public Reply createNewGame(Long playerId){
//        create game object with random continent and identified player (using id))
        Continent continent = gameListService.getRandomContinent();
        Game game = new Game(
                continent,
                playerService.getPlayerById(playerId).get()
        );
//        save the game
        gameRepository.save(game);
//        return a reply
        return new Reply(game.getScore(), game.maxScore(), game.getPenalty(), "How many countries can you name in " + continent.getName());

//   TODO: If we were to add a GameMode we would have to add GameMode as a class, pass it into the properties and constructor of Game, and in the GameController and GameServices we need to also have GameMode in the parameter
//   TODO: Also, in this method, we need to create a variable for gameMode and at the end, when returning and reply, use an if statement (for the mode)
    }

    //get all games
    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    // get game by ID
    public Optional<Game> getGameById(Long id){
        return gameRepository.findById(id);
    }

    public void deleteGame(Long id){
        gameRepository.deleteById(id);
    }


}

