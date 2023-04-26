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
    CountryService countryService;

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


    //   When you use the @Transactional annotation, Spring creates a transactional context around the method and all database operations within the method are executed within the same transaction. This means that if any of the database operations fail, the entire transaction will be rolled back, ensuring data consistency.
//
//    Without the @Transactional annotation, each database operation is executed independently, which can lead to data inconsistencies if any of the operations fail. For example, if you first delete the associated Country entities and then attempt to delete the Continent entity but the deletion fails due to a foreign key constraint violation, the Country entities will have already been deleted and their associated Continent reference will no longer exist, resulting in data inconsistencies.
//
//   So, in summary, it is strongly recommended to use the @Transactional annotation when deleting entities that have relationships with other entities to ensure data consistency.

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


}