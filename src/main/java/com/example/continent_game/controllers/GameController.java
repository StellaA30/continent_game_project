package com.example.continent_game.controllers;

import com.example.continent_game.models.*;
import com.example.continent_game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    GameService gameService;

//    CREATE
//          post new game

//    TODO: ASK ZSOLT ABOUT HOW TO CREATE A GAME
    @PostMapping
    public ResponseEntity<Reply> createNewGame(@RequestParam long playerId) {
    Reply reply = gameService.createNewGame(playerId);
//        Game newGame = gameService.createNewGame(playerId);
    return new ResponseEntity<>(reply, HttpStatus.CREATED);
}


//    READ

//          get all games
    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameService.getAllGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

//          get game by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        Optional<Game> game = gameService.getGameById(id);
        if(game.isPresent()){
            return new ResponseEntity<>(game.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


//    UPDATE
//          patch game status (for example if you can't think of any more countries and want to end the game early)
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Reply> endGameEarly(@PathVariable Long id) {
        Reply reply = gameService.terminateGame(id);
        return new ResponseEntity<>(reply, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    private ResponseEntity<Reply> makeAGuess(@RequestBody Guess guess, @PathVariable Long id) {
        Reply reply = gameService.processGuess(guess, id);
        return new ResponseEntity<>(reply, HttpStatus.OK);
    }


//    DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePlayer(@PathVariable Long id) {
        gameService.deleteGame(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }






}
