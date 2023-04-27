package com.example.continent_game.services;

import com.example.continent_game.models.Continent;
import com.example.continent_game.models.Country;
import com.example.continent_game.models.CountryDTO;
import com.example.continent_game.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ContinentService continentService;


    //save country
    public Country addNewCountry(CountryDTO countryDTO){
        Continent continent = continentService.findSingleContinent(countryDTO.getContinentId());
        Country newCountry = new Country(countryDTO.getName(), countryDTO.getGDP(), countryDTO.getCapital(), countryDTO.getPopulation(),continent);
        countryRepository.save(newCountry);
        return newCountry;
    }


    //Read
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    public Optional <Country> getCountry(Long id) {
        return countryRepository.findById(id);
    }


    public Country updateCountry(Long id, CountryDTO countryDTO){
        Continent continent = continentService.findSingleContinent(countryDTO.getContinentId());
        Country countryLocatedById = countryRepository.findById(id).get();
        countryLocatedById.setName(countryDTO.getName());
        countryLocatedById.setGDP(countryDTO.getGDP());
        countryLocatedById.setPopulation(countryDTO.getPopulation());
        countryLocatedById.setContinent(continent);
        countryLocatedById.setCapital(countryDTO.getCapital());
        countryRepository.save(countryLocatedById);
        return countryLocatedById;
    }

    //Delete
    public boolean deleteCountry(Long id) {
        Optional<Country> optionalCountry = countryRepository.findById(id);
        if (optionalCountry.isPresent()) { //check if it is in country object
            countryRepository.deleteById(id); //delete the country object with given id
            return true; //successfully deleted
        }
        return false; //if not found in the repository it can not be deleted
    }

}
