package com.example.continent_game.components;

import com.example.continent_game.models.Continent;
import com.example.continent_game.models.Country;
import com.example.continent_game.repositories.ContinentRepository;
import com.example.continent_game.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ContinentRepository continentRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) {

//        CONTINENTS
        Continent continentAfrica = new Continent("Africa");
        continentRepository.save(continentAfrica);
        Continent continentEurope = new Continent("Europe");
        continentRepository.save(continentEurope);
        Continent continentNorthAmerica = new Continent("NorthAmerica");
        continentRepository.save(continentNorthAmerica);


        ////        CONTINENT: String name,
////        COUNTRY: String name, Long GDP, String capital, int population, Continent, continent)

//        COUNTRIES IN EUROPE
        Country countryUnitedKingdom = new Country("United Kingdom", 3100000000000L, "London", 67330000, continentEurope);
        Country countryFrance= new Country("France", 5100000000000L, "France", 100330000, continentEurope);
        Country countryIreland= new Country("Ireland", 300000000000L, "Dublin", 100330000, continentEurope);
        countryRepository.save(countryUnitedKingdom);
        countryRepository.save(countryFrance);
        countryRepository.save(countryIreland);

//        COUNTRIES IN AFRICA
        Country countryEgypt = new Country("Egypt", 3100000000000L, "Cairo", 67330000, continentAfrica);
        Country countryDjibouti= new Country("Djibouti", 5100000000000L, "Djibouti", 100330000, continentAfrica);
        Country countrySouthAfrica= new Country("SouthAfrica", 300000000000L, "Johannesburg??", 100330000, continentAfrica);
        countryRepository.save(countryEgypt);
        countryRepository.save(countryDjibouti);
        countryRepository.save(countrySouthAfrica);

//        List<String> rawAfricanCountryStrings = Arrays.asList(
//                "Ghana",
//                "Nigeria",
//                "Egypt",
//                "South Africa",
//                "Morocco",
//                "Zimbabwe"
//        );
//
//        List<String> rawEuropeCountryStrings = Arrays.asList(
//                "UK",
//                "Ireland",
//                "France",
//                "Italy",
//                "Germany",
//                "Spain"
//        );
//
////        CONTINENT: String name,
////        COUNTRY: String name, Long GDP, String capital, int population, Continent, continent)
//
//        Continent continentAfrica = new Continent("Africa");
//
////        1)
//
//
//
//
//        for(String rawCountryString : rawAfricanCountryStrings){
//            Continent continent = new Continent("Africa");
//            continentRepository.save(continent);
//        }




    }


}
