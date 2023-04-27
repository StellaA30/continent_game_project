package com.example.continent_game.controllers;


import com.example.continent_game.models.Country;
import com.example.continent_game.models.CountryDTO;
import com.example.continent_game.models.Reply;
import com.example.continent_game.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/countries")
public class CountryController {
    @Autowired
    CountryService countryService;

    //READ
    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries(){
        List<Country> countries = countryService.getCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id){
        Optional<Country> country = countryService.getCountry(id);
        if (country.isPresent()){
            return new ResponseEntity<>(country.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //CREATE NEW COUNTRY
    @PostMapping
    public ResponseEntity<Country> createNewCountry(@RequestBody CountryDTO countryDTO){
        Country country = countryService.addNewCountry(countryDTO);
        return new ResponseEntity<>(country, HttpStatus.CREATED);
    }


    //UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id,
                                                 @RequestBody CountryDTO countryDTO){
        Country country = countryService.updateCountry(id, countryDTO);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }


    //DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Country> deleteContinentAndCountries(@PathVariable Long id){
        countryService.deleteCountry(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }


}
