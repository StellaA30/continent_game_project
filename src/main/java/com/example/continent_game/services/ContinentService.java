package com.example.continent_game.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.continent_game.models.Continent;
import com.example.continent_game.models.ContinentDTO;
import com.example.continent_game.models.Country;
import com.example.continent_game.repositories.ContinentRepository;
import com.example.continent_game.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContinentService {

    @Autowired
    ContinentRepository continentRepository;

    @Autowired
    CountryService countryService;

    // CRUD

//    TODO: Check if we need a DTO
    public void addNewContinent(Continent continent){
        continentRepository.save(continent);
    }

    public Optional<Continent> findContinent(Long id){
        return continentRepository.findById(id);
    }

    public List<Continent> findAllContinents(){
        return continentRepository.findAll();
    }

    //    ID TAKEN INTO CONSIDERATION IN CONTINENT CONTROLLER
    public void updateContinent(Continent continent){
        continentRepository.save(continent);
    }

    public void removeContinent(Long id){
        continentRepository.deleteById(id);
    }


}