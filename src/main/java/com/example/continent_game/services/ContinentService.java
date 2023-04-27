package com.example.continent_game.services;

import java.util.List;
import java.util.Optional;

import com.example.continent_game.models.Continent;
import com.example.continent_game.models.Country;
import com.example.continent_game.repositories.ContinentRepository;
import com.example.continent_game.repositories.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContinentService {

    @Autowired
    ContinentRepository continentRepository;


    @Autowired
    CountryRepository countryRepository;

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
    public void updateContinent(Continent continent, Long id){
        Continent continentToUpdate = continentRepository.findById(id).get();
        continentToUpdate.setName(continent.getName());
        continentRepository.save(continentToUpdate);
    }


    //DELETE continent and associated countries
    @Transactional
    public void deleteContinentAndCountries(Long id){
        Continent continent = continentRepository.findById(id).get();
        List<Country> countries = continent.getCountries();
        for(Country country:countries){
            country.setContinent(null); // Set the continent reference in each country to null
        }
        countryRepository.deleteAll(countries); //Delete all associated countries

        continentRepository.delete(continent);  // Delete the continent

    }

    public void removeContinent(Long id){
        continentRepository.deleteById(id);
    }


    // find the continent by id -- to use in the countryService & CountryDTO
    public Continent findSingleContinent(Long id){
        return continentRepository.findById(id).get();
    }


}