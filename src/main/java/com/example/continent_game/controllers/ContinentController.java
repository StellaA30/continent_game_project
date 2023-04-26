package com.example.continent_game.controllers;

import com.example.continent_game.models.Continent;
import com.example.continent_game.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "/continents")
public class ContinentController {

    @Autowired
    ContinentService continentService;

    @GetMapping
    public ResponseEntity<List<Continent>> getAllContinents(){
        List<Continent> players = continentService.findAllContinents();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Continent> getContinentById(@PathVariable Long id){
        Optional<Continent> continent = continentService.findContinent(id);
        if (continent.isPresent()){
            return new ResponseEntity<>(continent.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Continent> addNewContinent(@RequestBody Continent continent){
        continentService.addNewContinent(continent);
        return new ResponseEntity<>(continent, HttpStatus.CREATED);
    }

    //update
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Continent> updateContinent(@RequestBody Continent continent,
//                                                     @PathVariable Long id) {
//        continentService.updateContinent(continent, id);
//        return new ResponseEntity<>(continent, HttpStatus.OK);
//    }

    //delete
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Continent> removeContinent(@PathVariable Long id) {
//        continentService.removeContinent(id);
//        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
//    }
    //Detail: Key (id)=(1) is still referenced from table "countries".

    //update
    @PutMapping(value = "/{id}")
    public ResponseEntity<Continent> updateContinent(
            @PathVariable Long id,
            @RequestBody Continent continent){
        continentService.updateContinent(continent, id);
        return new ResponseEntity<>(continent, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Continent> deleteContinentAndCountries(@PathVariable Long id){
        continentService.deleteContinentAndCountries(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }




}
